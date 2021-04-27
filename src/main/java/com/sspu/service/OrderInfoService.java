package com.sspu.service;

import com.sspu.entity.OrderInfo;

import java.util.List;

public interface OrderInfoService {


    int deleteByPrimaryKey(String ordernumber);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(String ordernumber);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<OrderInfo> findAllOrderList(String ordernumber);

}



