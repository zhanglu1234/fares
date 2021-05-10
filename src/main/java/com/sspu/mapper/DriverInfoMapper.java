package com.sspu.mapper;

import com.sspu.entity.ClientInfo;
import com.sspu.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DriverInfoMapper {

    int deleteByPrimaryKey(Integer driverinfoid);

    int insert(DriverInfo record);

    int insertSelective(DriverInfo record);

    DriverInfo selectByPrimaryKey(Integer driverinfoid);

    int updateByPrimaryKeySelective(DriverInfo record);

    int updateByPrimaryKey(DriverInfo record);

    List<DriverInfo> selectAllByDriverIdNumber(String driveridnumber);

    List<DriverInfo> listBySelectedContent( @Param("driveridnumber") String driveridnumber, @Param("driverorderstatus") String driverorderstatus, @Param("orderBy") String orderBy);

//    List<DriverInfo> selectAllInfoOrderBy(String driveridnumber,@Param("orderBy") String orderBy);

    List<DriverInfo> findAllDriverApplyInfo(@Param("driverinfoid") Integer driverinfoid);
}
