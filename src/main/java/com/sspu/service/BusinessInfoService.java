package com.sspu.service;

import com.sspu.entity.BusinessInfo;
import com.sspu.entity.OrderInfo;

import java.util.List;

public interface BusinessInfoService {


    int deleteByPrimaryKey(Integer businessid);

    int insert(BusinessInfo record);

    int insertSelective(BusinessInfo record);

    BusinessInfo selectByPrimaryKey(Integer businessid);

    int updateByPrimaryKeySelective(BusinessInfo record);

    int updateByPrimaryKey(BusinessInfo record);

    int selectBusinessAndPassword(String businessname, String businesspassword);

    BusinessInfo selectBusinessInfoByBusinessName(String businessname);

}


