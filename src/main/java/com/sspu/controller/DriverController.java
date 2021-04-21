package com.sspu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sspu.config.Config;
import com.sspu.entity.DriverInfo;
import com.sspu.service.DriverInfoService;
import com.sspu.utils.CheckIdNumber;
import com.sspu.utils.CheckPhoneNumber;
import com.sspu.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import javax.xml.validation.Validator;
import java.util.List;


@RestController
@RequestMapping("/applyInfo")
@CrossOrigin
@Slf4j
public class DriverController {


    @Autowired
    DriverInfoService driverInfoService;

    @Autowired
    CheckIdNumber checkIdNumber;

    @Autowired
    CheckPhoneNumber checkPhoneNumber;


    /**
     * 司机申请入/出园区
     *
     * @param driverInfo
     * @return
     */

    @PostMapping("/insertInfo")
    ResultVo insertDriverInfo(@RequestBody DriverInfo driverInfo) {
        ResultVo resultVo = new ResultVo();
        //验证用户身份证号码
        boolean driverIdNumberResult = checkIdNumber.check(driverInfo.getDriveridnumber());
        //验证手机号码
        boolean phoneLegal = checkPhoneNumber.isPhoneLegal(driverInfo.getDriverphone() + "");
        if (driverIdNumberResult && phoneLegal) {
            try {
                int insert = driverInfoService.insertSelective(driverInfo);

                if (insert != 0) {
                    return resultVo.SUCCESS(insert);
                }
            } catch (Exception e) {
                return resultVo.Fail(402, "申请失败！");
            }
        } else {
            resultVo.Fail(402, "申请失败！");
        }
        return resultVo;
    }

    /**
     * 获取某一司机申请出/入园所有记录
     *
     * @param driverIdNumber
     * @return
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

    /**
     * 展示司机申请信息
     *
     * @param driveridnumber
     * @param driverorderstatus
     * @param orderBy
     * @return
     */

    @GetMapping("/listBySelectedContent")
    ResultVo listBySelectedContent(@RequestParam String driveridnumber, String driverorderstatus, String orderBy) {

        ResultVo resultVo = new ResultVo();
        String sort = orderBy.equals("0") ? "DESC" : "ASC";
        try {
            List<DriverInfo> list;
            list = driverInfoService.listBySelectedContent(driveridnumber, driverorderstatus, sort);
            return resultVo.SUCCESS(list);
        } catch (Exception e) {
            System.out.println("错误");
        }
        return resultVo;
    }

    /**
     * 小程序获取所有用户信息
     * @return
     */

//    @GetMapping("/getAllDriverInfo")
//    ResultVo getAllDriverInfo() {
//        ResultVo resultVo = new ResultVo();
//        try {
//            List<DriverInfo> allDriverApplyInfo = driverInfoService.findAllDriverApplyInfo();
//            if (allDriverApplyInfo != null) {
//                return resultVo.SUCCESS(allDriverApplyInfo);
//            } else {
//                resultVo.Fail(402, "没有申请记录");
//            }
//        } catch (Exception e) {
//            resultVo.Fail(402, "没有申请记录");
//        }
//        return resultVo;
//    }

    /**
     * 申请列表分页
     *
     * @param config
     * @return
     */

    @PostMapping("/AllDriverInfoByManage")
    ResultVo getAllDriverInfoByManage(@RequestBody Config config) {
        PageHelper.startPage(config.getPageNum(), config.getPageSize());
        ResultVo resultVo = new ResultVo();
        try {
            List<DriverInfo> allDriverApplyInfo = driverInfoService.findAllDriverApplyInfo(config.getDriverInfoId());
            if (allDriverApplyInfo != null) {
                PageInfo<DriverInfo> driverInfoPageInfo = new PageInfo<>(allDriverApplyInfo);
                return resultVo.SUCCESS(driverInfoPageInfo);
            } else {
                resultVo.Fail(402, "没有申请记录");
            }
        } catch (Exception e) {
            resultVo.Fail(402, "没有申请记录");
        }
        return resultVo;
    }

    /**
     * 更新司机申请信息
     * @param driverInfo
     * @return
     */
    @PatchMapping("/updateDriverApplyInfo")
    ResultVo updateDriverApplyInfo(@RequestBody DriverInfo driverInfo) {
        ResultVo resultVo = new ResultVo();
        int result;
        try {
            result = driverInfoService.updateByPrimaryKeySelective(driverInfo);
            if (result >0) {
                return resultVo.SUCCESS(result);
            } else {
                resultVo.Fail(402, "更新失败");
            }
        } catch (Exception e) {
            resultVo.Fail(402, "更新失败");
        }
        return resultVo;
    }

    /**
     * 根据司机id获取司机申请信息
     * @param driverInfoId
     * @return
     */

    @GetMapping("/infoByDriverInfoId")
    ResultVo selectInfoByDriverInfoId(@RequestParam Integer driverInfoId) {

        ResultVo resultVo = new ResultVo();
        try {
            DriverInfo driverInfo = driverInfoService.selectByPrimaryKey(driverInfoId);
            if (driverInfo != null) {
                ResultVo success = resultVo.SUCCESS(driverInfo);
                return success;
            } else {
                resultVo.Fail(402, "没有申请记录");
            }
        } catch (Exception e) {
            resultVo.Fail(402, "请求失败");
        }
        return resultVo;
    }

    @DeleteMapping("/deleteDriverInfo")
    ResultVo deleteDriverInfo(@RequestParam Integer driverInfoId) {

        ResultVo resultVo = new ResultVo();
        try {
            int result = driverInfoService.deleteByPrimaryKey(driverInfoId);
            if (result >0) {
                ResultVo success = resultVo.SUCCESS(result);
                return success;
            } else {
                resultVo.Fail(402, "没有申请记录");
            }
        } catch (Exception e) {
            resultVo.Fail(402, "请求失败");
        }
        return resultVo;
    }

}
