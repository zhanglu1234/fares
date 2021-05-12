package com.sspu.entity;

import java.util.Date;
import lombok.Data;

/**
 * businessInfo
 */
@Data
public class BusinessInfo extends BaseInfo{
//    /**
//     * ID
//     */
//    private Integer id;

    /**
     * 名称
     */
    private String businessname;

    /**
     * 密码
     */
    private String businesspassword;

    /**
     * 错误次数
     */
    private Integer businessloginerror;

    /**
     * 登录时间
     */
    private Date businessallowedlogintime;

//    /**
//     * 创建时间
//     */
//    private Date creattime;
//
//    /**
//     * 更新时间
//     */
//    private Date updatetime;
//
//    /**
//     * 是否可见
//     */
//    private String isvisible;
//
//    /**
//     * 创建人
//     */
//    private String createby;
}
