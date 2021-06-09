package com.sspu.service.impl;

import com.sspu.vo.DriverClientOrderVo;
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
    public Integer selectClientIdByClientUniqueId(String clientuniqueid) {
        return clientInfoMapper.selectClientIdByClientUniqueId(clientuniqueid);
    }

    @Override
    public List<DriverClientOrderVo> selectInfoExaminedApplyByClient(Integer Id) {
        return clientInfoMapper.selectInfoExaminedApplyByClient(Id);
    }

    @Override
    public List<DriverClientOrderVo> findListBySelectedContent(String clientuniqueid, String driverapplystatus, String applyBy) {
        return clientInfoMapper.findListBySelectedContent(clientuniqueid,driverapplystatus,applyBy);
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
    public List<ClientInfo> findAllClientInfo(Integer clientid) {
        return clientInfoMapper.findAllClientInfo(clientid);
    }


    @Override
    public int selectByUniqueIdAndPassword(String clientuniqueid, String clientpassword) {
        return clientInfoMapper.selectByUniqueIdAndPassword(clientuniqueid, clientpassword);
    }

    @Override
    public ClientInfo selectByClientUniqueId(String clientUniqueId) {
        return clientInfoMapper.selectByClientUniqueId(clientUniqueId);
    }

}





