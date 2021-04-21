package com.sspu.controller;

import com.sspu.entity.ClientInfo;
import com.sspu.service.ClientInfoService;
import com.sspu.utils.JwtUtils;
import com.sspu.utils.Temps;
import com.sspu.vo.ResultVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

//支持跨域
@CrossOrigin
@RestController
@RequestMapping("/clientLogin")
public class ClientLoginController {
    @Autowired
    ClientInfoService clientInfoService;

    @Autowired
    Temps temps;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping("/client")
    ResultVo clientLogin1(@RequestBody ClientInfo clientInfo) {
        ResultVo resultVo = new ResultVo();
        //获取当前时间
        Date nowDate = new Date();
        //密码加密
        String encodedPassword = temps.getDigest(Temps.encode(clientInfo.getClientpassword()));
        try{
            //用户名与密码是否一致
            int result = clientInfoService.selectByUniqueIdAndPassword(clientInfo.getClientuniqueid(), encodedPassword);
            //获取用户信息
            ClientInfo client = clientInfoService.selectByClientUniqueId(clientInfo.getClientuniqueid());
            //获取用户id
            Integer clientId = client.getClientid();
            //允许登录时间
            Date clientAllowedLoginTime = client.getClientallowedlogintime();
            //获取用户登录错误次数
            Integer clientLoginError = client.getClientloginerror();
            if (nowDate.after(clientAllowedLoginTime)) {
                if (clientLoginError >= 3) {
                    Date dateAfterAllowTime = new Date(nowDate.getTime() + 30000);
                    clientLoginError = 0;
                    updateClientLoginTime(clientId, dateAfterAllowTime, clientLoginError);
                    return resultVo.FailLogin("密码已错过3次，请稍后登录");
                } else {
                    if (result > 0) {
                        clientLoginError = 0;
                        clientAllowedLoginTime = new Date();
                        updateClientLoginTime(clientId, clientAllowedLoginTime, clientLoginError);
                        Map<String, Object> dataMap = new HashMap<>();
                        dataMap.put("getClientUniqueId", clientInfo.getClientuniqueid());
                        String token = jwtUtils.createJwt(clientInfo.getClientuniqueid(), dataMap);
                        return resultVo.SuccessToken(result, token);
                    } else {
                        ClientInfo newClient = new ClientInfo();
                        clientLoginError = clientLoginError + 1;
                        newClient.setClientid(clientId);
                        newClient.setClientloginerror(clientLoginError);
                        clientInfoService.updateByPrimaryKeySelective(newClient);
                        return resultVo.FailLogin( "用户名或密码已错" + clientLoginError + "次，请重新登录！");

                    }
                }
            } else {
                return resultVo.FailLogin("当前时间不允许登录，请稍后登录");
            }
        }catch(Exception e){
            System.out.println("用户登录失败！");
        }
        return resultVo;
    }


    public void updateClientLoginTime(Integer clientId, Date clientAllowedLoginTime, Integer clientLoginError) {
        ClientInfo newClient = new ClientInfo();
        newClient.setClientid(clientId);
        newClient.setClientallowedlogintime(clientAllowedLoginTime);
        newClient.setClientloginerror(clientLoginError);
        try {
            clientInfoService.updateByPrimaryKeySelective(newClient);
        } catch (Exception e) {
            System.out.println("用户信息更新失败！");
        }
    }
}
