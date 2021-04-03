package com.sspu.controller;

import com.sspu.entity.ClientInfo;
import com.sspu.service.ClientInfoService;
import com.sspu.utils.Temps;
import com.sspu.vo.ResultVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//支持跨域
@CrossOrigin
@RestController
@RequestMapping("/clientLogin")
public class ClientLoginController {
    @Autowired
    ClientInfoService clientInfoService;

    @Autowired
    Temps temps;

    @PostMapping("/client")
    ResultVo clientLogin(@RequestBody ClientInfo clientInfo){
        ResultVo resultVo = new ResultVo();
        String encodedPassword = temps.getDigest(Temps.encode(clientInfo.getClientpassword()));
        try{
            int i = clientInfoService.selectByUniqueIdAndPassword(clientInfo.getClientuniqueid(), encodedPassword);
            if(i!=0){
               return resultVo.SUCCESS(i);
            }else {
                resultVo.Fail(400,"没有该用户信息");
            }
        }catch(Exception e){
            return resultVo.Fail(402, "用户名和密码不一致");
        }
        return resultVo;
    }


}
