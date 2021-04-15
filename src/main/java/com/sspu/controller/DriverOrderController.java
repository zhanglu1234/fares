package com.sspu.controller;

import com.sspu.entity.DriverInfo;
import com.sspu.service.DriverInfoService;
import com.sspu.service.OrderInfoService;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/driverOrderInfo")
@RestController
public class DriverOrderController {


    @Autowired
    DriverInfoService driverInfoService;

    /*
    获取司机申请出/入园所有记录
     */
    @GetMapping("/driverIdNumber")
    ResultVo selectDriverAllInfoByDriverIdNumber(@RequestParam String driverIdNumber) {

        ResultVo resultVo = new ResultVo();
        try {
            List<DriverInfo> list = driverInfoService.selectAllByDriverIdNumber(driverIdNumber);
            System.out.println(list.size());
            if (list.size() > 0) {
                ResultVo success = resultVo.SUCCESS(list);
                return success;
            } else {
                resultVo.Fail(402, "没有申请记录");
            }
        } catch (Exception e) {
            resultVo.Fail(402, "请求失败");
        }
        return resultVo;
    }
    @GetMapping("/driverUntreatedApplyInfo")
    ResultVo selectDriverUntreatedApplyInfo(@RequestParam String driverIdNumber, String driverOrderStatus) {

        ResultVo resultVo = new ResultVo();
        try {
            List<DriverInfo> list = driverInfoService.selectUntreatedApplyInfo(driverIdNumber, driverOrderStatus);
            if (list.size() > 0) {
                ResultVo untreatedApplyInfo = resultVo.SUCCESS(list);
                return untreatedApplyInfo;
            } else {
                resultVo.Fail(402, "没有未处理的申请记录");
            }
        } catch (Exception e) {
            resultVo.Fail(402, "没有申请记录");
        }
        return resultVo;
    }

    @GetMapping("/driverApplyInfoByTimeDesc")
    ResultVo selectDriverApplyInfoByTimeDesc(@RequestParam String driverIdNumber) {

        ResultVo resultVo = new ResultVo();
        try {
            List<DriverInfo> list = driverInfoService.selectDriverApplyInfoByDesc(driverIdNumber);
            if (list.size() > 0) {
                ResultVo untreatedApplyInfo = resultVo.SUCCESS(list);
                return untreatedApplyInfo;
            } else {
                resultVo.Fail(402, "没有未处理的申请记录");
            }

        } catch (Exception e) {
            resultVo.Fail(402, "没有申请记录");
        }

        return resultVo;
    }

    @GetMapping("/driverUntreatedApplyInfoByTimeDesc")
    ResultVo selectDriverUntreatedApplyInfoByTimeDesc(@RequestParam String driverIdNumber, String driverOrderStatus) {

        ResultVo resultVo = new ResultVo();
        try {
            List<DriverInfo> list = driverInfoService.selectDriverUntreatedApplyInfoByTimeDesc(driverIdNumber, driverOrderStatus);
            if (list.size() > 0) {
                ResultVo untreatedApplyInfoByTimeDesc = resultVo.SUCCESS(list);
                return untreatedApplyInfoByTimeDesc;
            } else {
                resultVo.Fail(402, "没有未处理的申请记录");
            }
        } catch (Exception e) {
            resultVo.Fail(402, "没有申请记录");
        }
        return resultVo;
    }


}
