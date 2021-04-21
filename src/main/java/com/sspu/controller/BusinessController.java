package com.sspu.controller;

import com.sspu.entity.BusinessInfo;
import com.sspu.vo.ResultVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.sound.sampled.Line;
import java.util.logging.Logger;

@CrossOrigin
@RequestMapping("/businessLogin")
@RestController
@Slf4j
public class BusinessController {



    @PostMapping("/login")
    ResultVo businessLogin(@RequestBody BusinessInfo businessInfo) {


        ResultVo resultVo = new ResultVo();
        try {
            if ((businessInfo.getBusinessname().equals("admin")) && (businessInfo.getBusinesspassword().equals("123456"))) {

                return resultVo.SuccessLogin();
            }
        } catch (Exception e) {
            return resultVo.Fail(400, "用户名和密码不一致");
        }
        return resultVo;
    }
}
