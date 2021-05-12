package com.sspu.mapper;

import com.sspu.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface DriverInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DriverInfo record);

    int insertSelective(DriverInfo record);

    DriverInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DriverInfo record);

    int updateByPrimaryKey(DriverInfo record);

    List<DriverInfo> selectAllByDriverIdNumber(String driveridnumber);

    List<DriverInfo> listBySelectedContent(@Param("driveridnumber") String driveridnumber, @Param("driverorderstatus") String driverorderstatus, @Param("orderBy") String orderBy);

    List<DriverInfo> findAllDriverApplyInfo(@Param("id") Integer id);
}
