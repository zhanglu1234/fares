package com.sspu.entity;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class BaseInfo {

    public Integer id;

    /**
     * 创建时间
     */
    private Date createtime=new Date();

    /**
     * 更新时间
     */
    private Date updatetime=new Date();


    /**
     * 创建人
     */
    private String createby;

    /**
     * 是否可见
     */
    private String isvisible;


}
