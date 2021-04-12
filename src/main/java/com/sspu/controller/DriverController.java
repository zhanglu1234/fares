package com.sspu.controller;

import com.sspu.entity.DriverInfo;
import com.sspu.service.DriverInfoService;
import com.sspu.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import java.util.List;


@RestController
@RequestMapping("/applyInfo")
@CrossOrigin
@Slf4j
public class DriverController {


    @Autowired
    DriverInfoService driverInfoService;

    @GetMapping("/allDriverInfo")
    ResultVo findAllDriverInfo() {
        ResultVo resultVo = new ResultVo();
        try {
            List<DriverInfo> list = driverInfoService.findAllDriverInfo();
            return resultVo.SUCCESS(list);
        } catch (Exception e) {
            resultVo.Fail(400, "获取信息列表失败");
        }
        return resultVo;
    }


    /*
    获取司机申请记录
     */
    @GetMapping("/selectByInfoDriverName")
    ResultVo selectByInfoName(@RequestParam String drivername) {

        ResultVo resultVo = new ResultVo();
        try {
            List<DriverInfo> list = driverInfoService.selectAllByDriverName(drivername);
            return resultVo.SUCCESS(list);
        } catch (Exception e) {
            resultVo.Fail(400, "无法获取司机申请记录");
        }
        return resultVo;
    }


    @PostMapping("/insertInfo")
    ResultVo insertDriverInfo(@RequestBody DriverInfo driverInfo) {

        log.info("insertInfo controller");

        ResultVo resultVo = new ResultVo();
        try {
            int insert = driverInfoService.insert(driverInfo);
            return resultVo.SUCCESS(insert);

        } catch (Exception e) {
            resultVo.Fail(500, "发生错误");
        }
        return resultVo;
    }


}
