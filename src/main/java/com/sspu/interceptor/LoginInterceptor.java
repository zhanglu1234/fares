package com.sspu.interceptor;

import com.alibaba.fastjson.JSON;
import com.sspu.FaresApplication;
import com.sspu.entity.ClientInfo;
import com.sspu.service.ClientInfoService;
import com.sspu.utils.JwtUtils;
import com.sspu.vo.ResultVo;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
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

        if (token == null || token.equals("null")) {
            System.out.println("———————————————————— token 为空——————————————————");
           returnJson(response);
            return false;
        }
        Claims claims = null;
        try {
            claims = jwtUtils.parseJwt(token);
            Date expiration = claims.getExpiration();
            ClientInfo clientInfo = clientInfoService.selectByClientUniqueId(claims.getId());
            System.out.println(clientInfo);
            boolean afterTime = expiration.after(nowDate);
            if (clientInfo!=null && afterTime) {
                System.out.println("****************token有效*************");
                return true;
            } else {
                System.out.println("————————token过期——————————————————————");
                returnJson(response);
                return false;
            }
        } catch (Exception e) {
            System.out.println("token 解析错误！");
            returnJson(response);
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void returnJson(HttpServletResponse response){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            Map<String, Object> map = new HashMap();
            map.put("code", 401);
            map.put("msg", "用户令牌token无效");
            String string = JSON.toJSONString(map);
            writer.print(string);
        } catch (IOException e) {
            System.out.println("returnJson 失败");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
