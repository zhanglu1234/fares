package com.sspu.interceptor;

import com.alibaba.fastjson.JSON;
import com.sspu.FaresApplication;
import com.sspu.service.ClientInfoService;
import com.sspu.utils.JwtUtils;
import com.sspu.vo.ResultVo;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@CrossOrigin
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private ClientInfoService clientInfoService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        response.setHeader("Access-Control-Allow-Credentials", "true");
        Date nowDate = new Date();
        String token = request.getHeader("token");
        System.out.println("————————————————打印token——————————————————————————————");
        System.out.println(token);
        if (token == null) {
            System.out.println("———————————————————— token 为空——————————————————");
            return false;
        }
        Claims claims = null;
        try {
            claims = jwtUtils.parseJwt(token);
        } catch (Exception e) {

            System.out.println("token 解析错误！");

            returnJson(response);

            return false;
        }


        Date expiration = claims.getExpiration();
        System.out.println(expiration);
        int i = clientInfoService.selectByClientUniqueId(claims.getId());
        System.out.println(claims.getExpiration().after(nowDate));
        boolean afterTime = expiration.after(nowDate);
        if (i >= 0 && afterTime) {

            System.out.println("****************token有效*************");


            return true;
        } else {
            System.out.println("————————token过期——————————————————————");
            returnJson(response);
            return false;
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

//        String token = response.getHeader("token");
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5 * 1000);
//
//                    try {
//                        if(token!=null){
//                            Claims claims = jwtUtils.parseJwt(token);
//                            int i = clientInfoService.selectByClientUniqueId(claims.getId());
//                            if (i != 0 && claims.getExpiration().before(new Date())) {
//                                throw new RuntimeException("token失效");
////                    System.out.println("token失效");
//                            }
//                        }
//
//
//                    } catch (Exception e) {
////                        throw new RuntimeException("无token");
//                        System.out.println("无token");
//                    }
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void returnJson(HttpServletResponse response) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();


            Map<String,Object> map = new HashMap();
            map.put("code",401);


//            List<Integer> list = new ArrayList<>();
//
//     装箱       Integer integer = new Integer(4);
//
//
//      拆箱      int integer1 = list.get(0).intValue();





            map.put("msg","用户令牌token无效");

            //resultVo.Fail(400, "用户令牌token无效");


            String string = JSON.toJSONString(map);

//            String text = JSON.toJSONString(resultVo.Fail(4000,"dfctvgbhnj")); //序列化


            writer.print(string);
        } catch (IOException e) {
            System.out.println("eee");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }


    }
}
