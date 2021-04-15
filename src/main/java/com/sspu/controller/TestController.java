package com.sspu.controller;

import com.sspu.entity.ClientInfo;
import com.sspu.entity.DriverInfo;
import com.sspu.mapper.DriverInfoMapper;
import com.sspu.service.ClientInfoService;
import com.sspu.utils.JwtUtils;
import com.sspu.utils.Temps;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/logintest")
@RestController
public class TestController {

    @Autowired
    ClientInfoService clientInfoService;

    @Autowired
    Temps temps;

    @Autowired
    JwtUtils jwtUtils;

//
//    @PostMapping("/login")
//    ResultVo clientLogin(@RequestBody ClientInfo clientInfo) {
//        ResultVo resultVo = new ResultVo();
////        String encodedPassword = temps.getDigest(Temps.encode(clientInfo.getClientpassword()));
//        System.out.println(clientInfoService.selectByClientUniqueId(clientInfo.getClientuniqueid()));
//        if(clientInfoService.selectByClientUniqueId(clientInfo.getClientuniqueid())==null){
//
//        }
//        return resultVo;
//    }
}
