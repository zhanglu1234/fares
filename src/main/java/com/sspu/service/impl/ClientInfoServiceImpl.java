package com.sspu.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.sspu.mapper.ClientInfoMapper;
import com.sspu.entity.ClientInfo;
import com.sspu.service.ClientInfoService;

import java.util.List;

@Service
public class ClientInfoServiceImpl implements ClientInfoService {

    @Resource
    private ClientInfoMapper clientInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer clientid) {
        return clientInfoMapper.deleteByPrimaryKey(clientid);
    }

    @Override
    public int insert(ClientInfo record) {
        return clientInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ClientInfo record) {
        return clientInfoMapper.insertSelective(record);
    }

    @Override
    public ClientInfo selectByPrimaryKey(Integer clientid) {
        return clientInfoMapper.selectByPrimaryKey(clientid);
    }

    @Override
    public int updateByPrimaryKeySelective(ClientInfo record) {
        return clientInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ClientInfo record) {
        return clientInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ClientInfo> findAllClientInfo() {
        return clientInfoMapper.findAllClientInfo();
    }


}
