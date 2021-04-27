package com.sspu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sspu.config.Config;
import com.sspu.entity.BusinessInfo;
import com.sspu.entity.ClientInfo;
import com.sspu.entity.DriverInfo;
import com.sspu.entity.OrderInfo;
import com.sspu.mapper.BusinessInfoMapper;
import com.sspu.mapper.ClientInfoMapper;
import com.sspu.mapper.DriverInfoMapper;
import com.sspu.mapper.OrderInfoMapper;
import com.sspu.service.BusinessInfoService;
import com.sspu.service.ClientInfoService;
import com.sspu.utils.JwtUtils;
import com.sspu.utils.Temps;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@CrossOrigin
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    BusinessInfoService businessInfoService;

    @Autowired
    BusinessInfoMapper businessInfoMapper;


    @Autowired
    Temps temps;

    @Autowired
    JwtUtils jwtUtils;


//    @PostMapping("/")
//    ResultVo clientLogin1(@RequestBody BusinessInfo businessInfo) {
//
//
//        ResultVo resultVo = new ResultVo();
//
//        //获取当前时间
//        Date nowDate = new Date();
//        //密码加密
//        String encodedPassword = temps.getDigest(Temps.encode(businessInfo.getBusinesspassword()));
//        try {
//            //用户名与密码是否一致
//            int result = businessInfoService.selectBusinessAndPassword(businessInfo.getBusinessname(), encodedPassword);
//            //获取用户信息
//            BusinessInfo business = businessInfoService.selectBusinessInfoByBusinessName(businessInfo.getBusinessname());
//            //获取用户id
//            Integer businessId = business.getBusinessid();
//            //允许登录时间
//            Date businessAllowedLoginTime = business.getBusinessallowedlogintime();
//            //获取用户登录错误次数
//            Integer businessLoginError = business.getBusinessloginerror();
//            if (nowDate.after(businessAllowedLoginTime)) {
//                if (businessLoginError >= 3) {
//                    Date dateAfterAllowTime = new Date(nowDate.getTime() + 30000);
//                    businessLoginError = 0;
//                    updateBusinessLoginTime(businessId, dateAfterAllowTime, businessLoginError);
//                    return resultVo.FailLogin("密码已错过3次，请稍后登录");
//                } else {
//                    if (result > 0) {
//                        businessLoginError = 0;
//                        businessAllowedLoginTime = new Date();
//                        updateBusinessLoginTime(businessId, businessAllowedLoginTime, businessLoginError);
//                        Map<String, Object> dataMap = new HashMap<>();
//                        dataMap.put("getBusinessName", businessInfo.getBusinessname());
//                        String token = jwtUtils.createJwt(businessInfo.getBusinessname(), dataMap);
//                        System.out.println(token);
//                        return resultVo.SuccessToken(result, token);
//                    } else {
//                        BusinessInfo newBusiness = new BusinessInfo();
//                        businessLoginError = businessLoginError + 1;
//                        newBusiness.setBusinessid(businessId);
//                        newBusiness.setBusinessloginerror(businessLoginError);
//                        System.out.println(newBusiness);
//                        businessInfoService.updateByPrimaryKeySelective(newBusiness);
//                        System.out.println(newBusiness);
//                        return resultVo.FailLogin("用户名或密码已错" + businessLoginError + "次，请重新登录！");
//
//                    }
//                }
//            } else {
//                return resultVo.FailLogin("当前时间不允许登录，请稍后登录");
//            }
//        } catch (Exception e) {
//            System.out.println("用户登录失败！");
//        }
//        return resultVo;
//    }
//
//    public void updateBusinessLoginTime(Integer businessId, Date businessAllowedLoginTime, Integer businessLoginError) {
//        BusinessInfo businessInfo = new BusinessInfo();
//        businessInfo.setBusinessid(businessId);
//        businessInfo.setBusinessallowedlogintime(businessAllowedLoginTime);
//        businessInfo.setBusinessloginerror(businessLoginError);
//        try{
//            businessInfoService.updateByPrimaryKeySelective(businessInfo);
//        }catch(Exception e){
//            System.out.println("用户信息更新失败！");
//        }
//
//    }
}
