package com.sspu.controller;

import com.sspu.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {


    @ResponseBody
    @RequestMapping("/error/400")
    public ResultVo error() {

        System.out.println("权限error");
         ResultVo resultVo = new ResultVo();
         resultVo.setDate("htllo");


        return resultVo;
    }

}
