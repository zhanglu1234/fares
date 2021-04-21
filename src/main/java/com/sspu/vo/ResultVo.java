package com.sspu.vo;

import com.sspu.wx.utils.TokenUtils;
import lombok.Data;

import java.util.List;

@Data
public class ResultVo<T> {

    private int code;
    private String msg;
    private T data;
    private String token;



    public ResultVo SUCCESS(T data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
        return this;
    }



    public ResultVo SuccessLogin() {

        this.code = 200;
        this.msg = "登录成功";
        return this;
    }

    public ResultVo SuccessToken(T data,String token) {

        this.data = data;
        this.token = token;
        this.code = 200;
        this.msg = "成功获取token";
        return this;
    }


    public ResultVo Fail(int code, String msg) {

        this.code = code;
        this.msg = msg;
        return this;
    }
    public ResultVo FailLogin( String msg) {


        this.msg = msg;
        return this;
    }
}
