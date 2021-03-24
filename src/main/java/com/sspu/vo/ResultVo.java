package com.sspu.vo;

import lombok.Data;

@Data
public class ResultVo<T> {

    private int code;
    private String msg;
    private T date;


    public ResultVo SUCCESS(T date) {
        this.code = 200;
        this.msg = "OK";
        this.date = date;

        return this;
    }

    public ResultVo SuccessLogin(){

        this.code=200;
        this.msg="登录成功";
        return this;
    }


    public ResultVo Fail(int code,String msg){

        this.code=code;
        this.msg=msg;
        return this;
    }
}
