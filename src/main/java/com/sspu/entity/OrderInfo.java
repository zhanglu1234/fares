package com.sspu.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * order_info
 */
@Data
public class OrderInfo extends BaseInfo{


    /**
     * 订单号
     */
    private String ordernumber;

    /**
     * 订单状态:-1订单无效，1订单有效
     */
    private String orderstatus;

    /**
     * 缴费金额
     */
    private BigDecimal orderpayment;

    /**
     * 缴费状态：是否缴费 0未缴费 1已缴费 默认为0
     */
    private String orderpaymentstatus;

    /**
     * 缴费时间
     */
    private Date orderpaymenttime;

    /**
     * 客户id
     */
    private Integer orderclientid;

    /**
     * 司机id
     */
    private Integer orderdriverinfoid;


}
