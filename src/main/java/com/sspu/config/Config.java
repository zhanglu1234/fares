package com.sspu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "path")
@Data
@Component
public class Config {

   private String filePath;


   private Integer pageNum;

   private Integer pageSize;

   private Integer id;

//   private String orderNumber;
//
//   private Integer clientId;

}

