package com.sspu.controller;

import com.sspu.entity.DriverInfo;
import com.sspu.service.DriverInfoService;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/applyInfo")
public class DriverController {


    @Autowired
    DriverInfoService driverInfoService;

    @GetMapping("/allDriverInfo")
    ResultVo findAllDriverInfo(){
        ResultVo resultVo = new ResultVo();
        try{
           List<DriverInfo> list=driverInfoService.findAllDriverInfo();
           return resultVo.SUCCESS(list);
        }catch(Exception e){
          resultVo.Fail(400,"获取信息列表失败");
        }
        return resultVo;
    }
    @GetMapping("/selectByInfoId")
    ResultVo selectByInfoId(@RequestParam Integer driverInfoId ){
        ResultVo resultVo = new ResultVo();
        try{
           DriverInfo driverInfo= driverInfoService.selectByPrimaryKey(driverInfoId);
           resultVo.SUCCESS(driverInfo);
        }catch(Exception e){
           resultVo.Fail(400,"未找到该信息");
        }
        return resultVo;
    }


    @PostMapping("/insertInfo")
    ResultVo insertDriverInfo(@RequestBody DriverInfo driverInfo) {
        ResultVo resultVo = new ResultVo();
        try {
            int date = driverInfoService.insert(driverInfo);
            return resultVo.SUCCESS(date);
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
            return resultVo.SUCCESS(date);

        }catch(Exception e){
            resultVo.Fail(400,"删除失败");
        }
        return resultVo;
    }
    @PatchMapping("/updateInfo")
    ResultVo updateInfo(@RequestBody DriverInfo driverInfo){
        ResultVo resultVo = new ResultVo();
        try{
            int date = driverInfoService.updateByPrimaryKeySelective(driverInfo);
            return  resultVo.SUCCESS(date);
        }catch(Exception e){
            resultVo.Fail(400,"信息更新失败");
        }
        return resultVo;
    }


}
