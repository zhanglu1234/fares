package com.sspu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sspu.entity.BusinessInfo;
import com.sspu.mapper.BusinessInfoMapper;
import com.sspu.service.BusinessInfoService;

@Service
public class BusinessInfoServiceImpl implements BusinessInfoService {

    @Resource
    private BusinessInfoMapper businessInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer businessid) {
        return businessInfoMapper.deleteByPrimaryKey(businessid);
    }

    @Override
    public int insert(BusinessInfo record) {
        return businessInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(BusinessInfo record) {
        return businessInfoMapper.insertSelective(record);
    }

    @Override
    public BusinessInfo selectByPrimaryKey(Integer businessid) {
        return businessInfoMapper.selectByPrimaryKey(businessid);
    }

    @Override
    public int updateByPrimaryKeySelective(BusinessInfo record) {
        return businessInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BusinessInfo record) {
        return businessInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectBusinessAndPassword(String businessname, String businesspassword) {
        return businessInfoMapper.selectBusinessAndPassword(businessname, businesspassword);
    }

    @Override
    public BusinessInfo selectBusinessInfoByBusinessName(String businessname) {
        return businessInfoMapper.selectBusinessInfoByBusinessName(businessname);
    }


}




