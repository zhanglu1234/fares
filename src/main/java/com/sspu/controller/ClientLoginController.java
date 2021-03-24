package com.sspu.controller;

import com.sspu.entity.ClientInfo;
import com.sspu.service.ClientInfoService;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientLogin")
public class ClientLoginController {
    @Autowired
    ClientInfoService clientInfoService;

    @GetMapping("/client")
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
}
