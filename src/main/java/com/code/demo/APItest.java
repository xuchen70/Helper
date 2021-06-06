package com.code.demo;

import com.code.demo.bean.Encrypts;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class APItest {
    public static void main(String[] args) throws IOException {
//        testList();
//        String s = "{\"depaId\":\"04a3149f-38fb-4421-bda7-5ba6edffda4b\",\"restDate\":\"null\",\"vaccCode\":\"5601\"}";
//        String vaccCode = "{\"depaId\":\"04a3149f-38fb-4421-bda7-5ba6edffda4b\",\"date\":\"2021-06-06\",\"vaccCode\":\"5601\"}";
//
//
        String str = "{\"depaId\":\"076c67f6-16b0-43ab-a205-53cc16f54d31\",\"restDate\":\"null\",\"vaccCode\":\"5601\"}";
        String str2 = "{\"depaId\":\"076c67f6-16b0-43ab-a205-53cc16f54d31\",\"restDate\":\"null\",\"vaccCode\":\"5601\"}";
        System.out.println(Encrypts.encrypt(str));
        System.out.println(Encrypts.encrypt(str2));
//        System.out.println("===================");
//        System.out.println(Encrypts.encrypt(s));
//        System.out.println(Encrypts.encrypt(vaccCode));

//        System.out.println(System.currentTimeMillis());
//        double d = Math.random();
//        System.out.println(d);
//
//        BigDecimal b = new BigDecimal(d);
//        d = b.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println(d);
//
//        String s = Encrypts.timestampSalt();
//        System.out.println(s);
//        System.out.println(Encrypts.encryptHeads(s));
//
//
//        String t = "1622914041506489628";
//        System.out.println(Encrypts.encryptHeads(t));
//
//        String token= "-t-hpF508FH2sLMJ1DK5351k59pUqpZxvPFX371tdfrzVFN8zAB8MWlLjtuho4a2B2Q";
//        System.out.println(Encrypts.encryptHeads(Encrypts.tokenSalt(token,t)));


        String k = "hYAPOVzzgsPD8XXKeSRfCOL0X5wPtKzxYNFuiLElxvgIiThoszhwq10DK7IxQWWfSnBAD8jVaQYCynZucjW3MIW+TIuiu9x3RZASy8qficpNB9frMC2ct/L+lc7EP76VPkNGs0Z1cRCy0Ns6oyU4WWHmWmOXKa5Ktsp80lhqpjp7NIV5NmfYee5+H5amK7aJ8y3IsujGhlhE+1jobYJdO7AAYlRNIEgsHTcb4l8jU++PIKCnY1Y5CKJUBltRx0KUwmP0TcUvBrLbXLX8eGdJez++6XduRz2xQW/hRBtGv6jX9BLdMAA3TjxJ0wJ/yGQa";
        System.out.println(Encrypts.decrypt(k));

    }

    public static Map<String,String> getParamsMap(){
        return new java.util.TreeMap<>();
    }

    private static void testList() throws IOException {
        String d = "076c67f6-16b0-43ab-a205-53cc16f54d31";
        String time = "2021-06-05";
        String vaccCode = "5601";
        AppointmentHelp.listTheDate("上沙社康中心",d,vaccCode,vaccCode);
    }

    private static void testList2() throws IOException {
        String d = "076c67f6-16b0-43ab-a205-53cc16f54d31";
        String time = "2021-06-05";
        String vaccCode = "5601";
        AppointmentHelp.listTheDate("上沙社康中心",d,vaccCode,vaccCode);
    }
}
