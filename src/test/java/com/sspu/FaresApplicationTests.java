package com.sspu;

import com.mysql.cj.x.protobuf.Mysqlx;
import com.sspu.entity.DriverInfo;
import com.sspu.mapper.DriverInfoMapper;
import com.sspu.wx.config.WxConfig;
import com.sspu.wx.entity.TokenEntity;
import com.sspu.wx.utils.TokenUtils;
import jdk.nashorn.internal.parser.Token;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
class FaresApplicationTests {


    @Autowired
    DriverInfoMapper driverInfo;

    @Autowired
    DriverInfoMapper driverInfoMapper;


    @Resource
    WxConfig wxConfig;

    @Test
    void contextLoads() throws Exception{

         System.out.println(TokenUtils.token());

    }

//    @Test
//    void contextLoads3() {
//        DriverInfo driverInfo = new DriverInfo("dxrfhc","xdfchgvjhb",123.33,"fchgvjhbkj",1234);
//
//        System.out.println(driverInfo);
//        driverInfoMapper.insertSelective(driverInfo);
//
//    }


    @Test
    void contextLoads1() throws Exception{

        System.out.println(TokenEntity.token);


//        new Thread(()->{
//
//            try {
//                Thread.currentThread().sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            TokenEntity.token="hdfdfdfd";
//
//
//        }).start();



        while (true){

             Thread.currentThread().sleep(10000);

            System.out.println(TokenEntity.token);



        }

    }




}
