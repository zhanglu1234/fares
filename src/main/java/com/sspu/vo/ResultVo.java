package com.sspu.vo;

import com.sspu.wx.utils.TokenUtils;
import lombok.Data;

import java.util.List;

@Data
public class ResultVo<T> {

    private int code;
    private String msg;
    private T date;
    private String token;



    public ResultVo SUCCESS(T date) {
        this.code = 200;
        this.msg = "OK";
        this.date = date;
        return this;
    }



    public ResultVo SuccessLogin() {

        this.code = 200;
        this.msg = "登录成功";
        return this;
    }

    public ResultVo SuccessToken(T date,String token) {

        this.date = date;
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
}
