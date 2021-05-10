package com.sspu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sspu.config.Config;
import com.sspu.entity.ClientInfo;
import com.sspu.entity.OrderInfo;
import com.sspu.service.ClientInfoService;
import com.sspu.service.DriverInfoService;
import com.sspu.service.OrderInfoService;
import com.sspu.vo.DriverClientOrderVo;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
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
    ClientInfoService clientInfoService;


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
            List<DriverClientOrderVo> allOrderList = orderInfoService.findAllOrderList(config.getOrderNumber());
            for (int i = 0; i < allOrderList.size(); i++) {
                System.out.println(allOrderList);
            }
            if (allOrderList != null) {
                PageInfo<DriverClientOrderVo> orderInfoPageInfo = new PageInfo<>(allOrderList);
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

    /**
     * 后台更新订单信息+绑定客户
     *
     * @param orderInfo
     * @return
     */
    @PatchMapping("/updateOrderInfo")
    ResultVo updateOrderInfo(@RequestBody OrderInfo orderInfo) {
        ResultVo resultVo = new ResultVo();
        try {
            ClientInfo clientInfo = clientInfoService.selectByPrimaryKey(orderInfo.getOrderclientid());
            if (clientInfo != null) {
                if (orderInfo.getOrderstatus().equals("1")) {
                    orderInfoService.updateByPrimaryKeySelective(orderInfo);
                    return resultVo.SUCCESS("成功");
                } else {
                    return resultVo.Fail(402, "此订单已无效，不能进行相关操作！");
                }
            } else {
                resultVo.Fail(402, "未找到该客户");
            }
        } catch (Exception e) {
            resultVo.Fail(402, "订单更新失败！");
        }
        return resultVo;
    }

    /**
     * 后台订单无效
     *
     * @param
     * @return
     */
    @PatchMapping("deleteOrderInfo")
    ResultVo deleteOrderInfo(@RequestBody OrderInfo orderInfo) {
        System.out.println("++++++++++++++++++++++++++++++++");
        ResultVo resultVo = new ResultVo();
        try {
            if (orderInfo.getOrderstatus().equals("-1")) {
                orderInfoService.updateByPrimaryKeySelective(orderInfo);
                resultVo.SUCCESS("成功！");
            }else {
                resultVo.Fail(402, "删除订单信息失败！");
            }
        } catch (Exception e) {
            resultVo.Fail(402, "删除订单信息失败！");
        }
        return resultVo;
    }
}
