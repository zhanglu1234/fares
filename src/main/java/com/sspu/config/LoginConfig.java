package com.sspu.config;

import com.sspu.interceptor.LoginInterceptor;
import com.sspu.interceptor.ResourceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@CrossOrigin
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

//    @Autowired
//    ResourceInterceptor resourceInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration registration = registry.addInterceptor(loginInterceptor);
        registration.addPathPatterns("/**")
                .excludePathPatterns("/clientLogin/client1")
        .excludePathPatterns("/error/400");
      //  WebMvcConfigurer.super.addInterceptors(registry);


    }


}
