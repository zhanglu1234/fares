package com.sspu.service;

import com.sspu.entity.DriverInfo;

public interface DriverInfoService {


    int deleteByPrimaryKey(Integer driverInfoId);

    int insert(DriverInfo record);

    int insertSelective(DriverInfo record);

    DriverInfo selectByPrimaryKey(Integer driverInfoId);

    int updateByPrimaryKeySelective(DriverInfo record);

    int updateByPrimaryKey(DriverInfo record);

}




















