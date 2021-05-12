package com.sspu.mapper;

import com.sspu.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface ClientInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClientInfo record);

    int insertSelective(ClientInfo record);

    ClientInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClientInfo record);

    int updateByPrimaryKey(ClientInfo record);

    List<ClientInfo> findAllClientInfo(@Param("id") Integer id);

    int selectByUniqueIdAndPassword(@Param("clientuniqueid") String clientuniqueid, @Param("clientpassword") String clientpassword);

    ClientInfo selectByClientUniqueId(@Param("clientuniqueid") String clientuniqueid);
}
