package com.sspu.service;

import com.sspu.entity.DriverInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DriverInfoService {


    int deleteByPrimaryKey(Integer driverInfoId);

    int insert(DriverInfo record);

    int insertSelective(DriverInfo record);

    DriverInfo selectByPrimaryKey(Integer driverInfoId);

    int updateByPrimaryKeySelective(DriverInfo record);

    int updateByPrimaryKey(DriverInfo record);

    List<DriverInfo> selectAllByDriverIdNumber(String driveridnumber);

    List<DriverInfo> listBySelectedContent(String driveridnumber, String driverorderstatus, String orderBy);


    List<DriverInfo> findAllDriverApplyInfo(Integer driverinfoid);
}


























