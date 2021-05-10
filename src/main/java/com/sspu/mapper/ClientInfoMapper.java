package com.sspu.mapper;

import com.sspu.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ClientInfoMapper {
    int deleteByPrimaryKey(Integer clientid);

    int insert(ClientInfo record);

    int insertSelective(ClientInfo record);

    ClientInfo selectByPrimaryKey(Integer clientid);

    int updateByPrimaryKeySelective(ClientInfo record);

    int updateByPrimaryKey(ClientInfo record);

    List<ClientInfo> findAllClientInfo(@Param("clientid") Integer clientid);

    int selectByUniqueIdAndPassword(@Param("clientuniqueid") String clientuniqueid, @Param("clientpassword") String clientpassword);

    ClientInfo selectByClientUniqueId(@Param("clientuniqueid") String clientuniqueid);
}
