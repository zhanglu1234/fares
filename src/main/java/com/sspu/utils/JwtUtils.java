package com.sspu.utils;

import ch.qos.logback.core.net.SyslogOutputStream;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author:
 * @create: 2020-02-13 21:19
 **/
@Data
@Component
@ConfigurationProperties("jwt.config")
public class JwtUtils {
    //签名私钥
    private String key;

    //签名失效时间
    private Long failure;

    /**
     * 设置认证token
     *
     * @param id      用户登录ID
     * @param map     其他私有数据
     * @return
     */
    public String createJwt(String id, Map<String, Object> map) {


        //1、设置失效时间啊
        long now = System.currentTimeMillis();  //毫秒
        long exp = now + failure;

        //2、创建JwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder().setId(id)
                .setIssuedAt(new Date())
                //设置签名防止篡改
                .signWith(SignatureAlgorithm.HS256, key);

        //3、根据map设置claims
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jwtBuilder.claim(entry.getKey(), entry.getValue());
        }
        jwtBuilder.setExpiration(new Date(exp));

        //4、创建token
        String token = jwtBuilder.compact();
        return token;
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public Claims parseJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }

    /**
     * 配置jwt
     *
     * @return
     */


}
