package com.sspu.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.sspu.entity.OrderInfo;
import com.sspu.mapper.OrderInfoMapper;
import com.sspu.service.OrderInfoService;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Override
    public int deleteByPrimaryKey(String ordernumber) {
        return orderInfoMapper.deleteByPrimaryKey(ordernumber);
    }

    @Override
    public int insert(OrderInfo record) {
        return orderInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderInfo record) {
        return orderInfoMapper.insertSelective(record);
    }

    @Override
    public OrderInfo selectByPrimaryKey(String ordernumber) {
        return orderInfoMapper.selectByPrimaryKey(ordernumber);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInfo record) {

        return orderInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<OrderInfo> findAllOrderList(String ordernumber) {
        return orderInfoMapper.findAllOrderList(ordernumber);
    }


}



