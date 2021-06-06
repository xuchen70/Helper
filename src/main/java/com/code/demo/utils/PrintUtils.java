package com.code.demo.utils;

public class PrintUtils {
    public static void println(String format, Object... args) {
        System.out.println(String.format(format, args));
    }
}
