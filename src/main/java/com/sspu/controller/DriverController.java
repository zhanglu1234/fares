package com.sspu.controller;

import com.sspu.entity.DriverInfo;
import com.sspu.service.DriverInfoService;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/applyInfo")
public class DriverController {


    @Autowired
    DriverInfoService driverInfoService;

    @PostMapping("/insertInfo")
    ResultVo insertDriverInfo(@RequestBody DriverInfo driverInfo) {
        ResultVo resultVo = new ResultVo();
        try {
            int date = driverInfoService.insert(driverInfo);
            return resultVo.SUCCES(date);
        } catch (Exception e) {
            resultVo.Fail(400, "添加信息失败");
        }
        return resultVo;
    }


    @DeleteMapping("/deleteInfo")
    ResultVo deleteInfo(@RequestParam Integer driverinfoid) {
        ResultVo resultVo = new ResultVo();
        try{
            int date = driverInfoService.deleteByPrimaryKey(driverinfoid);
            return resultVo.SUCCES(date);

        }catch(Exception e){
            resultVo.Fail(400,"删除失败");
        }
        return resultVo;
    }


}
