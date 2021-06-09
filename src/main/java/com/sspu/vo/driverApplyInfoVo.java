package com.sspu.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Date;

@Data
public class driverApplyInfoVo {

    private Integer id;

    private String drivername;

    private String cardnumber;

    private String telphone;

    private String driverapplytype;

    private String driverapplystatus;

    private String drivercartype;

    private String drivercarnumber;

    private Date applydate;

    private String applytime;

    private java.util.Date createtime;
}
