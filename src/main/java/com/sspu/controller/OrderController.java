package com.sspu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sspu.config.Config;
import com.sspu.entity.DriverInfo;
import com.sspu.entity.OrderInfo;
import com.sspu.service.DriverInfoService;
import com.sspu.service.OrderInfoService;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/order")
@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    OrderInfoService orderInfoService;

    @Autowired
    DriverInfoService driverInfoService;

    @Autowired
    Config config;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    /**
     * 获取所有订单信息
     *
     * @param config
     * @return
     */
    @PostMapping("/getAllOrderInfo")
    ResultVo findAllOrderList(@RequestBody Config config) {
        PageHelper.startPage(config.getPageNum(), config.getPageSize());
        ResultVo resultVo = new ResultVo();
        try {

            List<OrderInfo> allOrderList = orderInfoService.findAllOrderList(config.getOrderNumber());
            if (allOrderList != null) {
                PageInfo<OrderInfo> orderInfoPageInfo = new PageInfo<>(allOrderList);
                return resultVo.SUCCESS(orderInfoPageInfo);
            } else {
                resultVo.Fail(402, "没有申请记录");
            }
        } catch (Exception e) {
            resultVo.Fail(402, "没有申请记录");
        }
        return resultVo;

    }

    /**
     * 后台根据订单号获取订单信息
     *
     * @param orderNumber
     * @return
     */

    @GetMapping("/getOrderInfoByOrderNumber")
    ResultVo selectOrderInfoByOrderNumber(@RequestParam String orderNumber) {
        ResultVo resultVo = new ResultVo();
        try {
            OrderInfo orderInfo = orderInfoService.selectByPrimaryKey(orderNumber);
            if (orderInfo != null) {
                return resultVo.SUCCESS(orderInfo);
            } else {
                resultVo.Fail(402, "查询失败！");
            }
        } catch (Exception e) {
            resultVo.Fail(402, "查询失败！");
        }
        return resultVo;
    }

    @Transactional
    @PatchMapping("/updateOrderInfo")
    ResultVo updateOrderInfo(@RequestBody OrderInfo orderInfo) {
        ResultVo resultVo = new ResultVo();
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setName("translation_InsertDriverInfo");
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            orderInfoService.updateByPrimaryKeySelective(orderInfo);
            DriverInfo driverInfo = new DriverInfo();
            driverInfo.setDriverinfoid(orderInfo.getOrderdriverinfoid());
            driverInfo.setDriverorderstatus(orderInfo.getOrderstatus());
            driverInfoService.updateByPrimaryKeySelective(driverInfo);
            dataSourceTransactionManager.commit(status);
            return resultVo.SUCCESS("成功");
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(status);
            resultVo.Fail(402, "失败！");
        }
        return resultVo;
    }

}
