package com.sspu.vo;

import lombok.Data;

@Data
public class ResultVo<T> {

    private int code;
    private String msg;
    private T date;

    public ResultVo SUCCES(T date) {
        this.code = 200;
        this.msg = "OK";
        this.date = date;

        return this;
    }

    public ResultVo SCUSSE(T date,String msg){

        this.code=200;
        this.msg=msg;
        this.date=date;
        return this;
    }


    public ResultVo Fail(int code,String msg){

        this.code=code;
        this.msg=msg;
        this.date=null;
        return this;
    }
}
