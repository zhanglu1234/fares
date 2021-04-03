package com.sspu.mapper;

import com.sspu.entity.BusinessInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusinessInfoMapper {
    int deleteByPrimaryKey(String businessname);

    int insert(BusinessInfo record);

    int insertSelective(BusinessInfo record);

    BusinessInfo selectByPrimaryKey(String businessname);

    int updateByPrimaryKeySelective(BusinessInfo record);

    int updateByPrimaryKey(BusinessInfo record);
}
