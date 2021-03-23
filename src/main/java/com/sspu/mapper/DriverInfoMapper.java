package com.sspu.mapper;

import com.sspu.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DriverInfoMapper {
    int deleteByPrimaryKey(Integer driverinfoid);

    int insert(DriverInfo record);

    int insertSelective(DriverInfo record);

    DriverInfo selectByPrimaryKey(Integer driverinfoid);

    int updateByPrimaryKeySelective(DriverInfo record);

    int updateByPrimaryKey(DriverInfo record);
}
