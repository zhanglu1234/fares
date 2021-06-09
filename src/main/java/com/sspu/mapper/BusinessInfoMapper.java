package com.sspu.mapper;

import com.sspu.entity.BusinessInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BusinessInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusinessInfo record);

    int insertSelective(BusinessInfo record);

    BusinessInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusinessInfo record);

    int updateByPrimaryKey(BusinessInfo record);

    BusinessInfo selectBusinessAndPassword(@Param("businessname") String businessname, @Param("businesspassword") String businesspassword);

    BusinessInfo selectBusinessInfoByBusinessName(String businessname);
}
