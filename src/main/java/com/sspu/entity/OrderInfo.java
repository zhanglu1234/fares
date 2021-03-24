package com.sspu.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class OrderInfo {
    @Autowired
    ClientInfo clientInfo;
    @Autowired
    DriverInfo driverInfo;
}
