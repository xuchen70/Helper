package com.code.demo.bean;

import com.code.demo.AppointmentHelp;
import com.code.demo.utils.PrintUtils;
import com.code.demo.utils.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Base64;

public class Encrypts {
    private static final int[] o = new int[]{214, 144, 233, 254, 204, 225, 61, 183, 22, 182, 20, 194, 40, 251, 44, 5, 43, 103, 154, 118, 42, 190, 4, 195, 170, 68, 19, 38, 73, 134, 6, 153, 156, 66, 80, 244, 145, 239, 152, 122, 51, 84, 11, 67, 237, 207, 172, 98, 228, 179, 28, 169, 201, 8, 232, 149, 128, 223, 148, 250, 117, 143, 63, 166, 71, 7, 167, 252, 243, 115, 23, 186, 131, 89, 60, 25, 230, 133, 79, 168, 104, 107, 129, 178, 113, 100, 218, 139, 248, 235, 15, 75, 112, 86, 157, 53, 30, 36, 14, 94, 99, 88, 209, 162, 37, 34, 124, 59, 1, 33, 120, 135, 212, 0, 70, 87, 159, 211, 39, 82, 76, 54, 2, 231, 160, 196, 200, 158, 234, 191, 138, 210, 64, 199, 56, 181, 163, 247, 242, 206, 249, 97, 21, 161, 224, 174, 93, 164, 155, 52, 26, 85, 173, 147, 50, 48, 245, 140, 177, 227, 29, 246, 226, 46, 130, 102, 202, 96, 192, 41, 35, 171, 13, 83, 78, 111, 213, 219, 55, 69, 222, 253, 142, 47, 3, 255, 106, 114, 109, 108, 91, 81, 141, 27, 175, 146, 187, 221, 188, 127, 17, 217, 92, 65, 31, 16, 90, 216, 10, 193, 49, 136, 165, 205, 123, 189, 45, 116, 208, 18, 184, 229, 180, 176, 137, 105, 151, 74, 12, 150, 119, 126, 101, 185, 241, 9, 197, 110, 198, 132, 24, 240, 125, 236, 58, 220, 77, 32, 121, 238, 95, 62, 215, 203, 57, 72};
    private static final long[] u = new long[]{462357, 472066609, 943670861, 1415275113, 1886879365, 2358483617L, 2830087869L, 3301692121L, 3773296373L, 4228057617L, 404694573, 876298825, 1347903077, 1819507329, 2291111581L, 2762715833L, 3234320085L, 3705924337L, 4177462797L, 337322537, 808926789, 1280531041, 1752135293, 2223739545L, 2695343797L, 3166948049L, 3638552301L, 4110090761L, 269950501, 741554753, 1213159005, 1684763257};
    private static final long[] a = new long[]{2746333894L, 1453994832L, 1736282519, 2993693404L};

    private static final byte[] iv = "4h0VXhpqwWy89xBk".getBytes();
    private static final byte[] decrypt_key = "d!6@7#C$Y%p&k*4Q".getBytes();
    //参数加密的key
    private static final byte[] params_key = "0~6@h#Y^k%O&1*jM".getBytes();
    //请求头中的otn和ybm生成的key
    private static final byte[] head_key = "1~z@o#K^K%p&u*IT".getBytes();
    private static byte[] key = null;

    public static void main(String[] args) {
//        System.out.println("sdfsdfsdf".contains(""));
//        Resp<UserInfoBean> userInfo = AppointmentHelp.getUserInfo();
//        System.out.println(userInfo);
//        sendMsg();
        String msg = "0~6@h#Y^k%O&1*jM";
        System.out.println(Arrays.toString(msg.getBytes()));
        //{"pageNum":1,"numPerPage":10,"areaCode":"440306","bactCode":"5601","outpName":"","outpMapLongitude":"","outpMapLatitude":"","corpCode":""}
        String json = "{\"pageNum\":1,\"numPerPage\":10,\"areaCode\":\"440306\",\"bactCode\":\"5601\",\"outpName\":\"\",\"outpMapLongitude\":\"\",\"outpMapLatitude\":\"\",\"corpCode\":\"\"}";
        System.out.println(Arrays.toString(json.getBytes()));

        padding(json);

        System.out.println("===iv==" + Arrays.toString(iv));
        System.out.println("===key==" + Arrays.toString(key));

        System.out.println(encrypt(json));
    }

    private static byte[] padding(String str) {
        int t = 16 - str.length() % 16;
        byte[] array = new byte[str.length() + t];
        byte[] bytes = str.getBytes();
        System.arraycopy(bytes, 0, array, 0, bytes.length);
        Arrays.fill(array, bytes.length, array.length, (byte) t);
        return array;
    }

    private static byte[] dePadding(byte[] b) {
        if (null == b)
            return null;
        int t = b[b.length - 1];
        byte[] temp = new byte[b.length - t];
        System.arraycopy(b,0,temp,0,temp.length);
        return temp;
//        return b.slice(0, b.length - t);
    }

    public static String encrypt(String params) {
        return encrypt(params,"cbc",EncryptType.PARAMS);
    }

    public static String encrypt(String params,EncryptType type) {
        return encrypt(params,"cbc",type);
    }

    public static String encryptHeads(String params) {
        return encrypt(params,"cbc",EncryptType.HEAD);
    }

    public static String decrypt(String params) {
        return decrypt(params,"cbc",EncryptType.DECRYPT);
    }

    public static String encrypt(String params, String mode,EncryptType type) {
        if (params == null) return null;
        choseKeyWithType(type);
        byte[] bytes = params.getBytes();
        PrintUtils.println("bytes length=%s====bytes=%s",bytes.length,Arrays.toString(bytes));
        byte[] padding = padding(params);
        int index = padding.length / 16;
        byte[] i = new byte[padding.length];
        if (mode.equals("cbc")) {
            int[] o = uint8ToUint32Block(iv);
            for (int u = 0; u < index; u++) {
                int a = 16 * u;
                int[] s = uint8ToUint32Block(padding, a);
                o[0] = o[0] ^ s[0];
                o[1] = o[1] ^ s[1];
                o[2] = o[2] ^ s[2];
                o[3] = o[3] ^ s[3];
                int[] f = doBlockCrypt(o, encryptRoundKeys());
                o = f;
                for (int c = 0; c < 16; c++)
                    i[a + c] = (byte) (f[(c / 4)] >> (3 - c) % 4 * 8 & 255);
            }
        }
       return Base64.getEncoder().encodeToString(i);
    }

    public static String decrypt(String params, String mode,EncryptType type) {
        if (params == null) return null;
        choseKeyWithType(type);
        byte[] bytes = Base64.getDecoder().decode(params);
        PrintUtils.println("=decrypt=====bytes.length=%s    ==bytes=%s",bytes.length,Arrays.toString(bytes));

        byte[] n = new byte[bytes.length];
        int index = bytes.length / 16;
        if (mode.equals("cbc")) {
            int[] i = uint8ToUint32Block(iv);
            for (int o = 0; o < index; o++) {
                int u = 16 * o;
                int[] a = uint8ToUint32Block(bytes, u);
                int[] s = doBlockCrypt(a, decryptRoundKeys());
                int[] f = new int[4];


                f[0] = i[0] ^ s[0];
                f[1] = i[1] ^ s[1];
                f[2] = i[2] ^ s[2];
                f[3] = i[3] ^ s[3];
                i = a;

                for (int c = 0; c < 16; c++){
                    n[u + c] = (byte) (f[(c / 4)] >> (3 - c) % 4 * 8 & 255);
                }
            }
        }
        byte[] v = dePadding(n);
        return new String(v);
    }

    private static void choseKeyWithType(EncryptType type) {
        if (type == EncryptType.PARAMS){
            key = params_key;
        }else if (type == EncryptType.HEAD){
            key = head_key;
        }else if (type == EncryptType.DECRYPT){
            key = decrypt_key;
        }
    }


    private static int[] doBlockCrypt(int[] e, int[] t) {
        int[] r = new int[36];
        System.arraycopy(e, 0, r, 0, e.length);
        for (int n = 0; n < 32; n++) {
            r[n + 4] = r[n] ^ tTransform1(r[n + 1] ^ r[n + 2] ^ r[n + 3] ^ t[n]);
        }
        int[] i = new int[4];
        i[0] = r[35];
        i[1] = r[34];
        i[2] = r[33];
        i[3] = r[32];
        return i;
    }

    private static int[] decryptRoundKeys(){
        return reverse(encryptRoundKeys());
    }

    private static int[] reverse(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i= 0;i<temp.length;i++){
            temp[i] = arr[arr.length - 1 -i];
        }
        return temp;
    }

    private static int[] encryptRoundKeys() {
        int[] encryptRoundKeys = new int[32];
        int[] e = new int[4];
        int[] t = new int[36];

        e[0] = key[0] << 24 | key[1] << 16 | key[2] << 8 | key[3];
        e[1] = key[4] << 24 | key[5] << 16 | key[6] << 8 | key[7];
        e[2] = key[8] << 24 | key[9] << 16 | key[10] << 8 | key[11];
        e[3] = key[12] << 24 | key[13] << 16 | key[14] << 8 | key[15];

        t[0] = (int) (e[0] ^ a[0]);
        t[1] = (int) (e[1] ^ a[1]);
        t[2] = (int) (e[2] ^ a[2]);
        t[3] = (int) (e[3] ^ a[3]);

        for (int r = 0; r < 32; r++){
            t[r + 4] = t[r] ^ tTransform2((int) (t[r + 1] ^ t[r + 2] ^ t[r + 3] ^ u[r]));
            encryptRoundKeys[r] = t[r + 4];
        }

        PrintUtils.println("===encryptRoundKeys=length=%s=     array=%s",encryptRoundKeys.length,Arrays.toString(encryptRoundKeys));
        return encryptRoundKeys;
    }

    private static int tTransform1(int i) {
        int i1 = tTransform(i);
        return linearTransform1(i1);
    }

    private static int tTransform2(int e) {
        int t = tauTransform(e);
        return linearTransform2(t);
    }

    private static int linearTransform2(int e) {
        return e ^ rotateLeft(e, 13) ^ rotateLeft(e, 23);
    }

    private static int tauTransform(int e) {
        return o[e >>> 24 & 255] << 24 | o[e >>> 16 & 255] << 16 | o[e >>> 8 & 255] << 8 | o[255 & e];
    }

    private static int linearTransform1(int e) {
        return e ^ rotateLeft(e, 2) ^ rotateLeft(e, 10) ^ rotateLeft(e, 18) ^ rotateLeft(e, 24);
    }

    private static int rotateLeft(int e, int t) {
        return e << t | e >>> 32 - t;
    }

    private static int tTransform(int e) {
        return o[e >>> 24 & 255] << 24 | o[e >>> 16 & 255] << 16 | o[e >>> 8 & 255] << 8 | o[255 & e];
    }


    public static int[] uint8ToUint32Block(byte[] iv) {
        return uint8ToUint32Block(iv, -1);

    }

    public static int[] uint8ToUint32Block(byte[] iv, int index) {
        int t = index == -1 ? 0 : index;
        int[] r = new int[4];
        r[0] = iv[t] << 24 | iv[t + 1] << 16 | iv[t + 2] << 8 | iv[t + 3];
        r[1] = iv[t + 4] << 24 | iv[t + 5] << 16 | iv[t + 6] << 8 | iv[t + 7];
        r[2] = iv[t + 8] << 24 | iv[t + 9] << 16 | iv[t + 10] << 8 | iv[t + 11];
        r[3] = iv[t + 12] << 24 | iv[t + 13] << 16 | iv[t + 14] << 8 | iv[t + 15];
        return r;
    }

    public static String timestampSalt() {
        double random = Math.random();
        BigDecimal b = new BigDecimal(random);
        random = b.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
        String str = String.valueOf(System.currentTimeMillis()) + String.valueOf((int)(1e6 * random));
        return StringUtils.padEnd(str,19,'0');

    }

    public static String tokenSalt(String token, String randomTimes){
        String n = token.substring(0, 5)
                , i = token.substring(5, 10)
                , a = token.substring(10, 12)
                , o = token.substring(12);
        return n + randomTimes.substring(0, 14) + i + randomTimes.substring(9, 10) + a + randomTimes.substring(16, 17) + o;
    }

    enum EncryptType{
        HEAD,PARAMS,DECRYPT
    }

    private static void sendMsg() {
        String msg = String.format(
                "=============预约成功=============\r\n" +
                        "预约码:  %s \r\n" +
                        "预约疫苗:  %s \r\n" +
                        "疫苗厂商:  %s \r\n" +
                        "接种门诊:  %s \r\n" +
                        "门诊地址:  %s \r\n" +
                        "预约时间:  %s \r\n" +
                        "接 种 人:  %s \r\n" +
                        "=======================================",
                "515615615151146",
                "生物医疗",
                "福永医院塘尾社康",
                "福永医院塘尾社康",
                "福海街道塘尾社区凤塘大道万里路2号",
                "2021-06-02 11:00:00",
                "张三"
        );
        try {
            AppointmentHelp.notifyMsg("预约成功2", msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
