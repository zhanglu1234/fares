package com.sspu.service;

import com.sspu.entity.ClientInfo;
import sun.awt.SunHints;

import java.util.List;

public interface ClientInfoService {


    int deleteByPrimaryKey(Integer clientid);

    int insert(ClientInfo record);

    int insertSelective(ClientInfo record);

//    int selectByPrimaryKey(String clientuniqueid);

    int updateByPrimaryKeySelective(ClientInfo record);

    int updateByPrimaryKey(ClientInfo record);

    List<ClientInfo> findAllClientInfo();

    int selectByUniqueIdAndPassword(String clientuniqueid,String clientpassword);
}

