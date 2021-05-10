package com.sspu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sspu.config.Config;
import com.sspu.entity.DriverInfo;
import com.sspu.entity.OrderInfo;
import com.sspu.service.DriverInfoService;
import com.sspu.service.OrderInfoService;
import com.sspu.utils.CheckIdNumber;
import com.sspu.utils.CheckPhoneNumber;
import com.sspu.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/applyInfo")
@CrossOrigin
@Slf4j
public class DriverController {


    @Autowired
    DriverInfoService driverInfoService;

    @Autowired
    OrderInfoService orderInfoService;

    @Autowired
    CheckIdNumber checkIdNumber;

    @Autowired
    CheckPhoneNumber checkPhoneNumber;


    /**
     * 司机申请入/出园区
     * 生成订单
     *
     * @param driverInfo
     * @return
     */
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    /**
     * 小程序获取某一司机申请出/入园所有记录
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
     * 小程序展示司机申请信息
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
        String sortStatus;
        if (driverorderstatus.equals("0")) {
            sortStatus = "已提交申请";
        } else if (driverorderstatus.equals("1")) {
            sortStatus = "已审核";
        } else {
            sortStatus = "全部信息";
        }

        try {
            List<DriverInfo> list;
            list = driverInfoService.listBySelectedContent(driveridnumber, sortStatus, sort);
            return resultVo.SUCCESS(list);
        } catch (Exception e) {
            System.out.println("错误");
        }
        return resultVo;
    }


    /**
     * 后台系统申请列表+分页
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

    @PostMapping("/insertInfo")
    ResultVo insertDriverInfo(@RequestBody DriverInfo driverInfo) {
        ResultVo resultVo = new ResultVo();
        //验证用户身份证号码
        boolean driverIdNumberResult = checkIdNumber.check(driverInfo.getDriveridnumber());
        //验证手机号码
        boolean phoneLegal = checkPhoneNumber.isPhoneLegal(driverInfo.getDriverphone() + "");
        if (driverIdNumberResult && phoneLegal) {
            try {
                driverInfoService.insertSelective(driverInfo);
                resultVo.SUCCESS("成功");
            } catch (Exception e) {
                resultVo.Fail(402, "失败");
            }
        } else {
            resultVo.Fail(402, "申请失败！");
        }
        return resultVo;
    }

    /**
     * 后台审核司机申请信息
     *
     * @param driverInfo
     * @return
     */
    @Transactional
    @PatchMapping("/updateDriverApplyInfo")
    ResultVo updateDriverApplyInfo(@RequestBody DriverInfo driverInfo) {
        ResultVo resultVo = new ResultVo();
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setName("translation_InsertDriverInfo");
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //开启事务
        TransactionStatus status = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        try {

            OrderInfo orderInfo = new OrderInfo();
            String orderId = UUID.randomUUID().toString().replaceAll("-", "");
            orderInfo.setOrdernumber(orderId);
            orderInfo.setOrderdriverinfoid(driverInfo.getDriverinfoid());
//            orderInfo.setOrdercarnumber(driverInfo.getDrivercarnumber());
//            orderInfo.setEventtype(driverInfo.getDriverapplytype());
//            orderInfo.setDatetime(driverInfo.getApplytime());
            if (driverInfo.getDriverorderstatus().equals("1")) {
                orderInfo.setOrderstatus(driverInfo.getDriverorderstatus());
            } else {
                return resultVo.Fail(402, "未生成订单");
            }
            driverInfoService.updateByPrimaryKeySelective(driverInfo);
//            生成订单
            orderInfoService.insertSelective(orderInfo);
            //提交事务
            dataSourceTransactionManager.commit(status);
            return resultVo.SUCCESS("成功");
        } catch (Exception e) {
            //事务回滚
            dataSourceTransactionManager.rollback(status);
            resultVo.Fail(402, "更新失败");
        }
        return resultVo;
    }

    /**
     * 根据司机id获取司机申请信息
     *
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

    /**
     * 后台删除司机申请信息
     *
     * @param driverInfoId
     * @return
     */

    @DeleteMapping("/deleteDriverInfo")
    ResultVo deleteDriverInfo(@RequestParam Integer driverInfoId) {
        ResultVo resultVo = new ResultVo();
        try {
            int result = driverInfoService.deleteByPrimaryKey(driverInfoId);
            if (result > 0) {
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
