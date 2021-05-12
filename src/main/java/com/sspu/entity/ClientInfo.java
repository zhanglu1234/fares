package com.sspu.entity;


import lombok.Data;

import java.util.Date;


@Data
public class ClientInfo extends BaseInfo{
//    /**
//     * ID
//     */
//    private Integer id;

    /**
     * 客户账号
     */
    private String clientuniqueid;

    /**
     * 账号密码
     */
    private String clientpassword;

    /**
     * 客户姓名
     */
    private String clientname;

    /**
     * 客户手机号码
     */
    private String clientphone;

    /**
     * 错误次数
     */
    private Integer clientloginerror;

    /**
     * 登录时间
     */
    private Date clientallowedlogintime;
//
//    /**
//     * 创建时间
//     */
//    private Date createtime;
//
//    /**
//     * 更新时间
//     */
//    private Date updatetime;
//
//    /**
//     * 是否可见1可见 -1 不可见
//     */
//    private String isvisible;
//
//    /**
//     * 创建人
//     */
//    private String createby;
}
