package com.sspu.wx.utils;

import com.sspu.wx.config.WxConfig;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import sun.net.www.http.HttpClient;

import javax.annotation.Resource;

public class TokenUtils {


    @Autowired
    public static WxConfig wx;

    public static String token() throws Exception {


        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx63c3aeb53a76d68b&secret=d910eb068790e7f2c1c47302c84b7f99");


        // 响应模型
        CloseableHttpResponse response = null;

        // 由客户端执行(发送)Get请求
        response = httpClient.execute(httpGet);
        // 从响应模型中获取响应实体

        System.out.println(response);

//
//
//            System.out.println(      response.toString());
//
        HttpEntity responseEntity = response.getEntity();
//               System.out.println("响应状态为:" + response.getStatusLine());
//


        System.out.println(responseEntity);


        return "token";
    }

}


