package com.sspu.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * order_info
 */
@Data
public class OrderInfo extends BaseInfo {
//    /**
//     * ID
//     */
//    private Integer id;

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
     * 申请id
     */
    private Integer orderapplyinfoid;

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
//     * 创建人
//     */
//    private String createby;
//
//    /**
//     * 是否可见
//     */
//    private String isvisible;
}
