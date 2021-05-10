package com.sspu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sspu.config.Config;
import com.sspu.entity.ClientInfo;
import com.sspu.entity.OrderInfo;
import com.sspu.service.ClientInfoService;
import com.sspu.utils.JwtUtils;
import com.sspu.utils.Temps;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/clientInfo")
public class ClientController {

    @Autowired
    ClientInfoService clientInfoService;

    @Autowired
    Config config;

    @Autowired
    Temps temps;

    @GetMapping("/selectByClientId")
    ResultVo selectByClientId(@RequestParam Integer clientId) {
        ResultVo resultVo = new ResultVo();
        try {
            ClientInfo clientInfo = clientInfoService.selectByPrimaryKey(clientId);
            resultVo.SUCCESS(clientInfo);
        } catch (Exception e) {
            resultVo.Fail(400, "没有该客户信息");
        }
        return resultVo;
    }

    /**
     * 后台客户信息展示
     * @param config
     * @return
     */

    @PostMapping("/findAllClientInfo")
    ResultVo findAllClientInfo(@RequestBody Config config) {
        ResultVo resultVo = new ResultVo();
        PageHelper.startPage(config.getPageNum(), config.getPageSize());
        try {
            List<ClientInfo> allClientInfo = clientInfoService.findAllClientInfo(config.getClientId());
            if (allClientInfo != null) {
                PageInfo<ClientInfo> orderInfoPageInfo = new PageInfo<>(allClientInfo);
                return resultVo.SUCCESS(orderInfoPageInfo);
            } else {
                resultVo.Fail(402, "没有申请记录");
            }
        } catch (Exception e) {
            resultVo.Fail(400, "无法获取用户列表");
        }
        return resultVo;
    }

    /**
     * 添加客户信息
     * @param clientInfo
     * @return
     */

    @PostMapping("/insertClientInfo")
    ResultVo insertClientInfo(@RequestBody ClientInfo clientInfo){
        ResultVo resultVo = new ResultVo();
        //密码加密
        String encodedPassword = temps.getDigest(Temps.encode(clientInfo.getClientpassword()));
        clientInfo.setClientpassword(encodedPassword);
        try{
            int i = clientInfoService.insertSelective(clientInfo);
            return  resultVo.SUCCESS(i);
        }catch(Exception e){
            resultVo.Fail(402,"错误");
        }
        return  resultVo;
    }


    @DeleteMapping("/deleteClientInfo")
    ResultVo deleteInfoByClientId(@RequestParam Integer clientId) {
        ResultVo resultVo = new ResultVo();
        try {
            int data = clientInfoService.deleteByPrimaryKey(clientId);
            resultVo.SUCCESS(data);
        } catch (Exception e) {
            resultVo.Fail(400, "请求错误");
        }
        return resultVo;
    }

    @PatchMapping("/updateClientInfo")
    ResultVo updateClientInfo(@RequestBody ClientInfo clientInfo) {
        ResultVo resultVo = new ResultVo();
        //密码加密
        String encodedPassword = temps.getDigest(Temps.encode(clientInfo.getClientpassword()));
        clientInfo.setClientpassword(encodedPassword);
        try {
            int data = clientInfoService.updateByPrimaryKeySelective(clientInfo);
//            updateByPrimaryKey更新后的时间信息为null
//            int data = clientInfoService.updateByPrimaryKey(clientInfo);
            resultVo.SUCCESS(data);
        } catch (Exception e) {
            resultVo.Fail(400, "用户信息更新失败");
        }
        return resultVo;
    }

}
