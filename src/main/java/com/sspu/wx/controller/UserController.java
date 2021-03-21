package com.sspu.wx.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.nio.cs.ext.MacArabic;

import java.util.Map;

@Controller

@RequestMapping("/user")
public class UserController {



         @RequestMapping("/user")
         void user(@RequestBody Map map){

            System.out.println(map);
        }

}
