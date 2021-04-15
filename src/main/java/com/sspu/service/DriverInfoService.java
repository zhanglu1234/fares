package com.sspu.service;

import com.sspu.entity.DriverInfo;

import java.util.List;

public interface DriverInfoService {


    int deleteByPrimaryKey(Integer driverInfoId);

    int insert(DriverInfo record);

    int insertSelective(DriverInfo record);

    DriverInfo selectByPrimaryKey(Integer driverInfoId);

    int updateByPrimaryKeySelective(DriverInfo record);

    int updateByPrimaryKey(DriverInfo record);

    List<DriverInfo> findAllDriverInfo();

    List<DriverInfo> selectAllByDriverName(String drivername);

    List<DriverInfo> selectAllByDriverIdNumber(String driveridnumber);

    List<DriverInfo> selectUntreatedApplyInfo(String driverIdNumber,String driverOrderStatus);

    List<DriverInfo> selectDriverApplyInfoByDesc(String driveridnumber);

    List<DriverInfo> selectDriverUntreatedApplyInfoByTimeDesc(String driveridnumber,String driverorderstatus);
}


























