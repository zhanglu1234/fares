package com.sspu.controller;

import com.sspu.vo.ResultVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.sound.sampled.Line;
import java.util.logging.Logger;

@RequestMapping("/businessLogin")
@RestController
@Slf4j
public class BusinessController {



    @GetMapping("/login")
    ResultVo businessLogin(@RequestParam String businessName, String businessPassword) {


        ResultVo resultVo = new ResultVo();
        try {
            if ((businessName.equals("admin")) && (businessPassword.equals("123456"))) {

                return resultVo.SuccessLogin();
            }

        } catch (Exception e) {
            return resultVo.Fail(400, "用户名和密码不一致");
        }
        return resultVo;
    }
}
