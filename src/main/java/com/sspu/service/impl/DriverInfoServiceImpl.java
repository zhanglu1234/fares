package com.sspu.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.sspu.mapper.DriverInfoMapper;
import com.sspu.entity.DriverInfo;
import com.sspu.service.DriverInfoService;

import java.util.List;

@Service
public class DriverInfoServiceImpl implements DriverInfoService {


    @Resource
    private DriverInfoMapper driverInfoMapper;

    @Override
    public List<DriverInfo> findAllDriverInfo() {
        return driverInfoMapper.findAllDriverInfo();
    }

    @Override
    public int deleteByPrimaryKey(Integer driverInfoId) {
        return driverInfoMapper.deleteByPrimaryKey(driverInfoId);
    }

    @Override
    public int insert(DriverInfo record) {
        return driverInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(DriverInfo record) {
        return driverInfoMapper.insertSelective(record);
    }

    @Override
    public DriverInfo selectByPrimaryKey(Integer driverInfoId) {
        return driverInfoMapper.selectByPrimaryKey(driverInfoId);
    }

    @Override
    public int updateByPrimaryKeySelective(DriverInfo record) {
        return driverInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DriverInfo record) {
        return driverInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<DriverInfo> selectAllByDriverName(String drivername) {
        return driverInfoMapper.selectAllByDriverName(drivername);
    }
}





