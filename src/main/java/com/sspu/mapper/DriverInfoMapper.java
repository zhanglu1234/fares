package com.sspu.mapper;

import com.sspu.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DriverInfoMapper {
    int deleteByPrimaryKey(Integer driverinfoid);

    int insert(DriverInfo record);

    int insertSelective(DriverInfo record);

    DriverInfo selectByPrimaryKey(Integer driverinfoid);

    int updateByPrimaryKeySelective(DriverInfo record);

    int updateByPrimaryKey(DriverInfo record);

    List<DriverInfo> findAllDriverInfo();

    List<DriverInfo> selectAllByDriverName(String drivername);
}
