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
            int state = driverInfoService.insert(driverInfo);
            return resultVo.SUCCES(state);
        } catch (Exception e) {
            resultVo.Fail(400, "错误");
        }
        return resultVo;
    }


    @DeleteMapping("/deleteInfo")
    int deleteInfo(@RequestParam Integer driverinfoid) {
        return driverInfoService.deleteByPrimaryKey(driverinfoid);
    }


}
