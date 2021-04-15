package com.sspu.entity;

import java.util.Date;
import lombok.Data;

@Data
public class ClientInfo {
    private Integer clientid;

    private String clientuniqueid;

    private String clientpassword;

    private Date datetime;

    private String clientname;

    private Integer clientphone;

    private Integer clientloginerror;

    private Date clientallowedlogintime;
}