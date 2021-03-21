package com.sspu.wx.thread;

import com.sspu.wx.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class TokenThread {


    public TokenThread() {

         new Thread(()->{

    System.out.println();

         }).start();


    }





}
