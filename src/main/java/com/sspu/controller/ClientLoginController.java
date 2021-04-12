package com.sspu.controller;

import com.sspu.entity.ClientInfo;
import com.sspu.service.ClientInfoService;
import com.sspu.utils.JwtUtils;
import com.sspu.utils.Temps;
import com.sspu.vo.ResultVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    ResultVo clientLogin(@RequestBody ClientInfo clientInfo) {
        ResultVo resultVo = new ResultVo();
        String encodedPassword = temps.getDigest(Temps.encode(clientInfo.getClientpassword()));
        try {
            int i = clientInfoService.selectByUniqueIdAndPassword(clientInfo.getClientuniqueid(), encodedPassword);
            if (i != 0) {
                return resultVo.SUCCESS(i);
            } else {
                resultVo.Fail(400, "没有该用户信息");
            }
        } catch (Exception e) {
            return resultVo.Fail(402, "用户名和密码不一致");
        }
        return resultVo;
    }

    @PostMapping("/client1")
    ResultVo clientLogin1(@RequestBody ClientInfo clientInfo) {
        ResultVo resultVo = new ResultVo();
        String encodedPassword = temps.getDigest(Temps.encode(clientInfo.getClientpassword()));
        try {
            int i = clientInfoService.selectByUniqueIdAndPassword(clientInfo.getClientuniqueid(), encodedPassword);
            if (i >= 0) {
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("getClientUniqueId", clientInfo.getClientuniqueid());
                //生成token并存入数据返回
                String token = jwtUtils.createJwt(clientInfo.getClientuniqueid(), dataMap);

                return resultVo.SuccessToken(i,token);
            } else {
                resultVo.Fail(400, "没有该用户信息");
            }
        } catch (Exception e) {
            return resultVo.Fail(402, "用户名和密码不一致");
        }
        return resultVo;
    }

}
