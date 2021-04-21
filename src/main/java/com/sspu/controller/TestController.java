package com.sspu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sspu.config.Config;
import com.sspu.entity.DriverInfo;
import com.sspu.mapper.ClientInfoMapper;
import com.sspu.mapper.DriverInfoMapper;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    DriverInfoMapper driverInfoMapper;

//    @PostMapping("/")
//    ResultVo getAllDriverInfo(@RequestBody Config config) {
//        PageHelper.startPage(config.getPageNum(),config.getPageSize());
//        ResultVo resultVo = new ResultVo();
//        try {
//            List<DriverInfo> allDriverApplyInfo = driverInfoMapper.findAllDriverApplyInfo();
//            if (allDriverApplyInfo != null) {
//                PageInfo<DriverInfo> driverInfoPageInfo = new PageInfo<>(allDriverApplyInfo);
//                return resultVo.SUCCESS(driverInfoPageInfo);
//            } else {
//                resultVo.Fail(402, "没有申请记录");
//            }
//        } catch (Exception e) {
//            resultVo.Fail(402, "没有申请记录");
//        }
//        return resultVo;
//    }
}
