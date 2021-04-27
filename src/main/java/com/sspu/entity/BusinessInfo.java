package com.sspu.entity;

import java.util.Date;
import lombok.Data;

/**
 * businessInfo
 */
@Data
public class BusinessInfo {
    private Integer businessid;

    /**
     * businessName
     */
    private String businessname;

    /**
     * businessPassword
     */
    private String businesspassword;

    private Date datetime;

    private Integer businessloginerror;

    private Date businessallowedlogintime;
}