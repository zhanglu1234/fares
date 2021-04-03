package com.sspu.entity;

import java.util.Date;
import lombok.Data;

/**
 * businessInfo
 */
@Data
public class BusinessInfo {
    /**
     * businessName
     */
    private String businessname;

    /**
     * businessPassword
     */
    private String businesspassword;

    private Date datetime;
}