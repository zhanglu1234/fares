package com.sspu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sspu.config.Config;
import com.sspu.entity.ClientInfo;
import com.sspu.entity.DriverInfo;
import com.sspu.entity.OrderInfo;
import com.sspu.service.ClientInfoService;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/test")
@CrossOrigin
@Slf4j
public class TestController {


    @Autowired
    DriverInfoService driverInfoService;

    @Autowired
    OrderInfoService orderInfoService;

    @Autowired
    CheckIdNumber checkIdNumber;

    @Autowired
    CheckPhoneNumber checkPhoneNumber;

    @Autowired
    ClientInfoService clientInfoService;
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    /**
     * 后台更新订单信息+绑定客户
     *
     * @param clientInfo
     * @return
     */
    @PostMapping("/insertClientInfo")
   ResultVo insertClientInfo(@RequestBody ClientInfo clientInfo){
        ResultVo resultVo = new ResultVo();
        try{
            int i = clientInfoService.insertSelective(clientInfo);
            return  resultVo.SUCCESS(i);
        }catch(Exception e){
            resultVo.Fail(402,"错误");
        }
        return  resultVo;
    }



}
