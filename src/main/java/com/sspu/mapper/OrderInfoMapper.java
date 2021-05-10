package com.sspu.mapper;

import com.sspu.entity.OrderInfo;
import com.sspu.vo.DriverClientOrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface OrderInfoMapper {
    int deleteByPrimaryKey(String ordernumber);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(String ordernumber);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<DriverClientOrderVo> findAllOrderList(@Param("ordernumber") String ordernumber);

    int updateOrderStatusByOrderNumber(OrderInfo orderInfo);
}
