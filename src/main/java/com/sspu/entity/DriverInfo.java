package com.sspu.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class DriverInfo extends BaseInfo{
//    /**
//     * ID
//     */
//    private Integer id;

    /**
     * 姓名
     */
    private String drivername;

    /**
     * 手机号码
     */
    private String driverphone;

    /**
     * 身份证号码
     */
    private String driveridnumber;

    /**
     * 车类型
     */
    private String drivercartype;

    /**
     * 车牌号
     */
    private String drivercarnumber;

    /**
     * 图片存放路径
     */
    private String driverpictureurl;

    /**
     * 出/入园
     */
    private String driverapplytype;

    /**
     * 申请状态 0 已提交申请 1已审核 -1失败
     */
    private String driverapplystatus;

    /**
     * 申请日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applydate;

    /**
     * 申请时段
     */
    private String applytime;

//
//    /**
//     * 创建人
//     */
//    private String createby;
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
//     * 是否可见
//     */
//    private String isvisible;
}
