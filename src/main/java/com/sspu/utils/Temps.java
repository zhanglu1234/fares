package com.sspu.utils;

import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Component
public class Temps {

    /**
     * 使用md5的算法进行加密
     * @param plainText 加密明文
     * @return 加密密文
     */
    public static String getDigest(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("error happens", e);
        }
        return new BigInteger(1, secretBytes).toString(16);
    }

    /**
     * 使用Base64进行编码
     * @param encodeContent 需要编码的内容
     * @return 编码后的内容
     */
    public static  String encode(String encodeContent) {
        if (encodeContent == null) {
            return null;
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(encodeContent.getBytes());
    }

    /**
     * 先使用MD5算法加密, 再使用base64算法进行编码
     * @param args
     */
//    public static void main(String[] args) {
//        String plainText = "123456";
//        String encodedPassword = getDigest(encode(plainText));
//        System.out.println(encodedPassword);
//    }
}
