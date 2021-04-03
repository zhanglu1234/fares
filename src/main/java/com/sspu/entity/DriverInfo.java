package com.sspu.entity;

import java.util.Date;
import lombok.Data;

@Data
public class DriverInfo {
    private Integer driverinfoid;

    private String drivername;

    private Double driverphone;

    private String driveridnumber;

    private String drivercartype;

    private String drivercarnumber;

    private String driverpictureurl;

    private String driverinfosource;

    private Date datetime;

    private String driverapplytype;

    private Date applytime;
}