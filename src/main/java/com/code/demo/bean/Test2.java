package com.code.demo.bean;

import java.util.Arrays;
import java.util.Base64;

public class Test2 {
    public static void main(String[] args) {
//        testDecrypt();
        testEncrypt();

    }

    private static void testEncrypt() {
        String t =  "{\"depaId\":\"2AA5C070-2605-B96B-E23B-85EAEE45DE8A\"}";
        String result = Encrypts.encrypt(t);
        System.out.println(result);

        String decrypt = Encrypts.decrypt(result);
        System.out.println(decrypt);
    }

    private static void testDecrypt() {
        String k ="hYAPOVzzgsPD8XXKeSRfCOL0X5wPtKzxYNFuiLElxvgIiThoszhwq10DK7IxQWWfSnBAD8jVaQYCynZucjW3MIW+TIuiu9x3RZASy8qficpNB9frMC2ct/L+lc7EP76VPkNGs0Z1cRCy0Ns6oyU4WWHmWmOXKa5Ktsp80lhqpjp7NIV5NmfYee5+H5amK7aJ8y3IsujGhlhE+1jobYJdO7AAYlRNIEgsHTcb4l8jU+8qm45K3B23WHHGRXv6d9aIw/JjnhKupv1Yx8xubZRBjl6UpLgIHhITCpICgwj53Hz+Wc0wJ/gi5hsIunk9EvL2";
        byte[] bytes = Base64.getDecoder().decode(k);
        int[] temp = new int[bytes.length];
        for (int i =0;i<bytes.length;i++){
            temp[i] = bytes[i] & 0xff;
        }
//        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(temp));


        System.out.println("====="+ Encrypts.decrypt(k));
        int i = 512;
        byte a = (byte) i ;
        System.out.println(a);


        System.out.println(Encrypts.encryptHeads("1623202724907238460"));
        System.out.println(Encrypts.tokenSalt("-t-hpF508FH2sLMJ1DK5351k59pUqpZxvPFX371tdfrzVFN8zAB8MWlLjtuho4a2B2Q","1623202724907238460"));
        System.out.println(Encrypts.encryptHeads(Encrypts.tokenSalt("-t-hpF508FH2sLMJ1DK5351k59pUqpZxvPFX371tdfrzVFN8zAB8MWlLjtuho4a2B2Q","1623202724907238460")));
    }
}
