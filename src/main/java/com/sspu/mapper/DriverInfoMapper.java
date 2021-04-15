package com.sspu.mapper;

import com.sspu.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DriverInfoMapper {

    List<DriverInfo> selectUntreatedApplyInfo(String driveridnumber,String driverorderstatus);

    int deleteByPrimaryKey(Integer driverinfoid);

    int insert(DriverInfo record);

    int insertSelective(DriverInfo record);

    DriverInfo selectByPrimaryKey(Integer driverinfoid);

    int updateByPrimaryKeySelective(DriverInfo record);

    int updateByPrimaryKey(DriverInfo record);

    List<DriverInfo> findAllDriverInfo();

    List<DriverInfo> selectAllByDriverName(String drivername);

    List<DriverInfo> selectAllByDriverIdNumber(String driveridnumber);

    List<DriverInfo> selectDriverApplyInfoByDesc(String driveridnumber);

    List<DriverInfo> selectDriverUntreatedApplyInfoByTimeDesc(String driveridnumber,String driverorderstatus);

    List<DriverInfo>  selectUntreatedInfoDesc(String driveridnumber,String driverorderstatus);
}
