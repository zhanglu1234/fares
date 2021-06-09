package com.sspu.service;

import com.sspu.entity.OrderInfo;
import com.sspu.vo.DriverClientOrderVo;

import java.util.List;

public interface OrderInfoService {


    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<DriverClientOrderVo> findAllOrderList(Integer id);

    int updateOrderStatusByOrderNumber(OrderInfo orderInfo);

    List<DriverClientOrderVo> driverFindAllOrderList(String cardNumber);

    List<DriverClientOrderVo> findListBySelectedContent(String cardNumber,String orderPaymentStatus,String applyBy);

}








