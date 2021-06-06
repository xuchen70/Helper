package com.code.demo.utils;

public class StringUtils {
    public static boolean isEmpty(String str){
        return str == null || str.equals("");
    }

    public static boolean notEmpty(String str){
        return !isEmpty(str);
    }

    public static String padEnd(String str,int length,char padChar){
        if (length < 0)
            throw new IllegalArgumentException("Desired length $length is less than zero.");
        if (length <= str.length())
            return str.subSequence(0, str.length()).toString();

        StringBuilder sb = new StringBuilder(length);
        sb.append(str);
        for (int i =1;i<(length - str.length());i++){
            sb.append(padChar);
        }
        return sb.toString();
    }
}
