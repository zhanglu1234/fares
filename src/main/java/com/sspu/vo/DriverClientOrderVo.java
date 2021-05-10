package com.sspu.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DriverClientOrderVo {

    /**
     * 订单号
     */
    private String ordernumber;

    /**
     * 订单状态:-1订单无效，0申请入园，1审核订单，2同意申请
     */
    private String orderstatus;

    /**
     * 缴费金额
     */
    private BigDecimal payment;

    /**
     * 缴费状态：是否缴费
     */
    private String paymentstatus;

    /**
     * 缴费时间
     */
    private Date paymenttime;

    /**
     * 出入园区状态
     */
    private String eventtype;

    /**
     * 车牌号
     */
    private String ordercarnumber;

    /**
     * 订单生成时间
     */
    private Date datetime;

    /**
     *
     */
    private Date applytime;
    /**
     * 客户id
     */
    private Integer orderclientid;

    /**
     * 司机id
     */
    private Integer orderdriverinfoid;

    private String drivername;

    private String clientuniqueid;

}
