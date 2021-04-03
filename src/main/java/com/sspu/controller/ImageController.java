package com.sspu.controller;

import com.sspu.config.Config;
import com.sspu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.xml.crypto.Data;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@RequestMapping("/getPicture")
@RestController
@CrossOrigin
@Component
public class ImageController {

    @Autowired
    private static Config config;

        @PostMapping("/picture")
        public ResultVo pictureUrl(@RequestBody String pictureurl) {

            ResultVo resultVo = new ResultVo();
            //对字节数组字符串进行Base64解码并生成图片
            if (pictureurl == null) //图像数据为空
                return resultVo.Fail(400,"没有读取数据");
            BASE64Decoder decoder = new BASE64Decoder();
            try
            {
                //Base64解码
                String baseValue = pictureurl.replaceAll("%2F", "/").replaceAll("%3A",":").replaceAll("%3B",";").replaceAll("%2C",",");
                byte[] b = decoder.decodeBuffer(baseValue.replace("data:image/png;base64,", ""));
                for(int i=0;i<b.length;++i)
                {
                    if(b[i]<0)
                    {//调整异常数据
                        b[i]+=256;
                    }
                }
                //生成png图片
                String basePath="/Users/zhanglu/Pictures/";
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String datePath= formatter.format(date);
                String uuid = UUID.randomUUID().toString().replaceAll("-","");
                String imgFilePath = basePath+datePath+uuid+".png";//新生成的图片
                System.out.println(imgFilePath);
                OutputStream out = new FileOutputStream(imgFilePath);
                out.write(b);
                out.flush();
                out.close();
                return resultVo.SUCCESS(imgFilePath);
            }
            catch (Exception e)
            {
               return resultVo.Fail(400,"图片保存失败");
            }
        }


        }
