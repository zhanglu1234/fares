package com.sspu.mapper;

import com.sspu.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ClientInfoMapper {
    int deleteByPrimaryKey(Integer clientid);

    int insert(ClientInfo record);

    int insertSelective(ClientInfo record);

    ClientInfo selectByPrimaryKey(Integer clientid);

    int updateByPrimaryKeySelective(ClientInfo record);

    int updateByPrimaryKey(ClientInfo record);

    List<ClientInfo> findAllClientInfo();

    int selectByUniqueIdAndPassword(String clientuniqueid, String clientpassword);

    ClientInfo selectByClientUniqueId(String clientuniqueid);
}
