package com.sspu.service;

import com.sspu.entity.BusinessInfo;
public interface BusinessInfoService{


    int deleteByPrimaryKey(String businessname);

    int insert(BusinessInfo record);

    int insertSelective(BusinessInfo record);

    BusinessInfo selectByPrimaryKey(String businessname);

    int updateByPrimaryKeySelective(BusinessInfo record);

    int updateByPrimaryKey(BusinessInfo record);

}
