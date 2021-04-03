package com.sspu.controller;

import com.sspu.entity.ClientInfo;
import com.sspu.service.ClientInfoService;
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

    @GetMapping("/client2")
    ResultVo clientLogin(@RequestParam String clientUniqueId, String clientPassword) {
        ResultVo resultVo = new ResultVo();
        List<ClientInfo> allClientInfo = clientInfoService.findAllClientInfo();
        for (int i = 0; i < allClientInfo.size(); i++) {
            if ((allClientInfo.get(i).getClientuniqueid().equals(clientUniqueId)) && (allClientInfo.get(i).getClientpassword().equals(clientPassword))) {
                return resultVo.SuccessLogin();
            }
        }
        return resultVo.Fail(402, "用户名和密码不一致");
    }

    @PostMapping("/client")
    ResultVo clientLogin(@RequestBody ClientInfo clientInfo) {
        ResultVo resultVo = new ResultVo();
        List<ClientInfo> allClientInfo = clientInfoService.findAllClientInfo();
        for (int i = 0; i < allClientInfo.size(); i++) {
            if ((allClientInfo.get(i).getClientuniqueid().equals(clientInfo.getClientuniqueid())) && (allClientInfo.get(i).getClientpassword().equals(clientInfo.getClientpassword()))) {
                return resultVo.SuccessLogin();
            }
        }
        return resultVo.Fail(402, "用户名和密码不一致");
    }
}
