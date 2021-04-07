package com.sspu.interceptor;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sspu.controller.ClientController;
import com.sspu.entity.ClientInfo;
import com.sspu.service.ClientInfoService;
import com.sspu.service.impl.ClientInfoServiceImpl;
import com.sspu.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;

@CrossOrigin
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private ClientInfoService clientInfoService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        if ("OPTIONS".equals(request.getMethod().toUpperCase())) {
            return true;
        }
        String token = request.getHeader("token");
        Claims claims = jwtUtils.parseJwt(token);
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // 执行认证
        if (token == null) {
            throw new RuntimeException("无token，请重新登录");
        }
        // 获取 token 中的 user id
        String clientUniqueId;
        try {
            clientUniqueId = claims.getId();
        } catch (Exception e) {
            throw new RuntimeException("401");
        }
//        int i = clientInfoService.selectByPrimaryKey(clientUniqueId);
//        if (i == 0) {
//            throw new RuntimeException("用户不存在，请重新登录");
//        }
        // 验证 token

//        JWTVerifier jwtVerifier = JWT.require().build();
//        try {
//            jwtVerifier.verify(token);
//        } catch (Exception e) {
//            throw new RuntimeException("401");
//        }
        return true;



    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
