package com.sspu.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;


@Data
public class DriverClientOrderVo {

    private Integer id;

    /**
     * 订单号
     */
    private String ordernumber;

    /**
     * 订单状态:-1订单无效，0申请入园，1审核订单，2同意申请
     */
    private String orderstatus;

    /**
     * 申请状态
     */

    private String driverapplystatus;
    /**
     * 缴费金额
     */
    private BigDecimal orderpayment;

    /**
     * 缴费状态：是否缴费
     */
    private String orderpaymentstatus;

    /**
     * 缴费时间
     */
    private Date orderpaymenttime;
    /**
     * 出/入园
     */

    private String driverapplytype;

    /**
     * 车牌号
     */
    private String drivercarnumber;


    /**
     * 申请日期
     */
    private Date applydate;

    /**
     * 申请时段
     */
    private String applytime;

    /**
     * 司机姓名
     */
    private String drivername;

    /**
     * 客户账号
     */
    private String clientuniqueid;

    /**
     * 申请时间
     */
    private java.util.Date createtime;

    /**
     * 手机号码
     */
    private String telphone;
    /**
     * 身份证号码
      */
    private  String cardnumber;
}
