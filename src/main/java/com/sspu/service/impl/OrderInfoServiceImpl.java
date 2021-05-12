package com.sspu.service.impl;

import com.sspu.vo.DriverClientOrderVo;
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
    public int deleteByPrimaryKey(Integer id) {
        return orderInfoMapper.deleteByPrimaryKey(id);
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
    public OrderInfo selectByPrimaryKey(Integer id) {
        return orderInfoMapper.selectByPrimaryKey(id);
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
    public List<DriverClientOrderVo> findAllOrderList(Integer id) {
        return orderInfoMapper.findAllOrderList(id);
    }

    @Override
    public int updateOrderStatusByOrderNumber(OrderInfo orderInfo) {
        return orderInfoMapper.updateOrderStatusByOrderNumber(orderInfo);
    }


}







