package com.sspu.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * order_info
 */
@Data
public class OrderInfo {
    /**
     * 订单号
     */
    private String ordernumber;

    /**
     * 订单状态:预约订单是否有效
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
     * 出入园区时间
     */
    private Date eventtime;

    /**
     * 客户id
     */
    private Integer orderclientid;

    /**
     * 司机id
     */
    private Integer orderdriverinfoid;
}