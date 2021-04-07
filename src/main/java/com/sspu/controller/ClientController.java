package com.sspu.controller;

import com.sspu.entity.ClientInfo;
import com.sspu.service.ClientInfoService;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/ClientInfo")
public class ClientController {

    @Autowired
    ClientInfoService clientInfoService;

//    @GetMapping("/selectByClientId")
//    ResultVo selectByClientId(@RequestParam Integer clientId) {
//        ResultVo resultVo = new ResultVo();
//        try {
//            ClientInfo clientInfo = clientInfoService.selectByPrimaryKey(clientId);
//            resultVo.SUCCESS(clientInfo);
//        } catch (Exception e) {
//            resultVo.Fail(400, "没有该客户信息");
//        }
//        return resultVo;
//    }

    @GetMapping("/findAllClientInfo")
    ResultVo findAllClientInfo() {
        ResultVo resultVo = new ResultVo();
        try {
            List<ClientInfo> list = clientInfoService.findAllClientInfo();
            resultVo.SUCCESS(list);
        } catch (Exception e) {
            resultVo.Fail(400, "无法获取用户列表");
        }
        return resultVo;
    }

    @PostMapping("/insertClientInfo")
    ResultVo insertClientInfo(@RequestBody ClientInfo clientInfo) {
        ResultVo resultVo = new ResultVo();
        try {
            int data = clientInfoService.insertSelective(clientInfo);
            resultVo.SUCCESS(data);
        } catch (Exception e) {
            resultVo.Fail(400, "添加用户信息失败");
        }
        return resultVo;
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
