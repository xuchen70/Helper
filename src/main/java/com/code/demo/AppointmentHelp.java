package com.code.demo;

import com.code.demo.bean.*;
import com.code.demo.utils.DateUtils;
import com.code.demo.utils.ParamsUtils;
import com.code.demo.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AppointmentHelp {
    private static OkHttpClient client = new OkHttpClient();
    private static int requestCount = 0;
    private static boolean isAppointment = true;
    //疫苗预约ID，提交结果时需要携带此参数
    private static String reusId;

    public static void main(String[] args) throws Exception {
        requestInfo();
    }

    private static void requestInfo() throws Exception {
//		String url = "https://xgsz.szcdc.net/crmobile/outpatient/nearby?areaCode=440306&corpCode=02&bactCode=5601&pageNum=1&numPerPage=20";
        String url = "https://xgsz.szcdc.net/crmobile/outpatient/nearby";
        Random random = new Random();
        getUserInfo();
        while (isAppointment) {
            getInfoByUrl(url);
            int next = random.nextInt(20000);
            Thread.sleep(next = Math.max(2000,next));
            println("休眠时间：%sms",next);
        }
    }


    private static void getInfoByUrl(String url) {
        Request request = postRequest(url, getFormParams());
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            public void onResponse(@NotNull Call call, @NotNull Response resp) throws IOException {
                ResponseBody body = resp.body();
                if (body != null) {
                    String json = body.string();
//                    println(json);
                    TypeToken<Resp<Data>> typeToken = new TypeToken<Resp<Data>>() {};
                    Resp<Data> rsp = new Gson().fromJson(json, typeToken.getType());
                    List<com.code.demo.bean.List> list = rsp.getData().getList();
                    for (com.code.demo.bean.List data : list) {
                        String currentDate = DateUtils.getCurrentDate();
                        String createDate = DateUtils.formatDate(DateUtils.PATTERN_DATE, data.getOutpStockcreatedDate());
                        //从目前接口来看状态 1为可以预约 2为满号状态
                        int workMode = data.getOutpWorkMode();
                        //从目前接口来看状态 holidaySkip 0为可以预约 1为未放号状态
                        int holidaySkip = data.getOutHolidaySkip();
                        boolean isUpdate = holidaySkip == Constant.WORKING;
                        String corpName = data.getCorpName();
                        println("当前接种点:%s      疫苗公司:%s   更新时间:%s   ", data.getOutpName(), corpName == null ? "未公布" : corpName, isUpdate ? data.getOutpUpdatedTime() : "未放号");
                        if (data.getStatus() == Constant.CAN_ORDER && isUpdate) {
                            String outpName = data.getOutpName();
                            println("%s有号啦,快速去查看！", outpName);
                            String corpCode = data.getCorpCode();
                            if (StringUtils.isEmpty(corpCode)){
                                continue;
                            }
//                            if (data.getOutpName() != null && corpCode.equals(Config.PREFER_VACCINE_CODE) && data.getOutpName().contains(Config.PREFER_PLACE)) {
//                                listTheDate(data.getDepaId(), "5601", corpCode);
//                            }

                            listTheDate(outpName,data.getDepaId(), "5601", corpCode);
                        }
                    }

                    println("任务刷新时间:%s   任务请求次数:%s", DateUtils.getCurrentDateAll(), ++requestCount);
                }
            }
        });
    }

    private static RequestBody getFormParams() {
        Map<String,String> params = ParamsUtils.getParamsMap();
        params.put("areaCode", "440306");
        params.put("corpCode", "");
        params.put("outpName", "");
        params.put("outpMapLongitude", "");
        params.put("outpMapLatitude", "");
        params.put("bactCode", "5601");//新冠疫苗代码
        params.put("pageNum", "1");
        params.put("numPerPage", "30");

        RequestBody formBody = new FormBody.Builder()
                .add("params", getEncryptParams(params))
//                .add("params","BEvehIahEMZGIT3yW02gFFmfxbDW2F5kZVe6MX/8SyUkRU0jZcGQUiVTKHhiRLz3NZqdKoB/BVxcMwK3zkcN19GyCcatyQgx7+q9zVHiF0/JwEUmIdUIQnInUp/gHbLDQxt1+KudHcAx0AmhUCEgvFfQnQPBy/TLcCmvAaGi6HQ0Q9cJNzKhUKWsgRsqrpOA")
                .build();
        return formBody;
    }

    /**
     * 通知用户有号啦
     *
     * @param text
     * @throws IOException
     */
    public static void notifyMsg(String text,String desp) throws IOException {
        String url = String.format("https://sc.ftqq.com/SCU68386T4e493bafc1111040c6499157139227a25def45de05cee.send?text=%s&desp=%s", text,desp);
        Request request = getRequest(url);
        Call call = client.newCall(request);
        Response response = call.execute();
        ResponseBody body = response.body();
        String string = body.string();
        System.out.println(string);

        /**
         * desp: >+*+整理知识，学习笔记
         * >+*+发布日记，杂文，所见所想
         * >+*+撰写发布技术文稿（代码支持）
         * >+*+撰写发布学术论文（LaTeX+公式支持）
         */

    }

    private static Request getRequest(String url) {
        return prepareRequest(url, true, null);
    }

    private static Request postRequest(String url, RequestBody body) {
        return prepareRequest(url, false, body);
    }

    private static Request prepareRequest(String url, boolean isGet, RequestBody body) {
        String token = "-t-hpF508FH2sLMJ1DK5351k59pUqpZxvPFX371tdfrzVFN8zAB8MWlLjtuho4a2B2Q";
        String s = Encrypts.timestampSalt();
        Request.Builder build = new Request.Builder().url(url)
                .addHeader("token", token)
                .addHeader("ybm", Encrypts.encryptHeads(s))
                .addHeader("otn", Encrypts.encryptHeads(Encrypts.tokenSalt(token,s)))
                .addHeader("appId", "app569d18f5")
                .addHeader("selfappid", "wx5402a9708b90332e")
//                .addHeader("reservationtoken", "470c88fb8e564742a81bee03682c0394")
                .addHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Mobile Safari/537.36 Edg/91.0.864.37")
                .addHeader("accept", "application/json, text/plain, */*")
                .addHeader("accept-language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
//                .addHeader("referer", "https://xgsz.szcdc.net/crmobile/?appId=app569d18f5&token=-t-hpF508FH2sLMJ1DK5351k59pUqpZxvPFX371tdfrzVFN8zAB8MWlLjtuho4a2B2Q&cardNo=6C283C0AA501C1DFAA84361F42FC24B19DC413A24EAE509CF93C7E609D4AB13D&reservationToken=6e043ad0314b430aa13878cfa77847f4&vaccineCode=5601&selfAppId=wx5402a9708b90332e")
                .addHeader("sec-ch-ua", " Not;A Brand ;v=99, Microsoft Edge;v=91, Chromium;v=91")
                .addHeader("sec-ch-ua-mobile", "?1")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-site", "same-origin")
                ;

        if (isGet) {
            return build.get().build();
        }
        String contentType = body instanceof FormBody ? "application/x-www-form-urlencoded" : "application/json;charset=UTF-8";
        build.addHeader("content-type", contentType);
        return build.post(body).build();
    }

    public static void listTheDate(String outpName ,String depaId, String vaccCode, String corpCode) throws IOException {
//		String url = "https://xgsz.szcdc.net/crmobile/reservationStock/list?depaId=97F00C04-E85B-9BAE-2277-E2B06E7B4E39&restDate=null&vaccCode=5601";
        Map<String,String> params = ParamsUtils.getParamsMap();
        params.put("vaccCode",vaccCode);
        params.put("restDate","null");
        params.put("depaId",depaId);
        String url = String.format("https://xgsz.szcdc.net/crmobile/reservationStock/list?params=%s", getEncryptParams(params));
        TypeToken<Resp<List<RestStatus>>> token = new TypeToken<Resp<List<RestStatus>>>() {};
        Resp<List<RestStatus>> resp = getRequest(url, token);
        println("=listTheDate===%s",resp);
        if (resp != null && resp.getEcode() == Constant.ERROR_SUCCEED) {
            String restDate = resp.getData().get(0).getRestDate();
            restDate = restDate.substring(0, restDate.indexOf(" "));
            listOrderTime(outpName,depaId, restDate, vaccCode, corpCode);
        }else {
            if (resp != null)
                println("请求出错，msg:%s",resp.getMsg());
        }

    }


    private static String getEncryptParams(Map<String, String> params) {
        String json = new Gson().toJson(params);
        String p = Encrypts.encrypt(json);
        println("====params=%s\nencrypt=%s=",json,p);
//        return Encrypts.encrypt(new Gson().toJson(params));
        return p;
    }

    private static <T> T getRequest(String url, TypeToken<T> token) throws IOException {
        return toRequest(getRequest(url), token);
    }

    private static <T> T postRequest(String url, RequestBody body, TypeToken<T> token) throws IOException {
        return toRequest(postRequest(url, body),token);
    }

    @Nullable
    private static <T> T toRequest(Request request,TypeToken<T> token) throws IOException {
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.body() == null) return null;
        String resp = response.body().string();
        try {
            return new Gson().fromJson(resp, token.getType());
        } catch (JsonSyntaxException e) {
            println("服务器返回数据有误");
            return null;
        }
    }

    /**
     * 加载时间表
     *
     * @param depaId
     * @param orderDate
     * @param vaccCode
     * @throws IOException
     */
    private static void listOrderTime(String outpName,String depaId, String orderDate, String vaccCode, String corpCode) throws IOException {
        Map<String,String> params = ParamsUtils.getParamsMap();
        params.put("depaId",depaId);
        params.put("date",orderDate);
        params.put("vaccCode",vaccCode);

        String url = String.format("https://xgsz.szcdc.net/crmobile/reservationStock/timeNumber?params=%s",getEncryptParams(params));
        TypeToken<Resp<List<TimeOrder>>> token = new TypeToken<Resp<List<TimeOrder>>>() {};
        Resp<List<TimeOrder>> resp = getRequest(url, token);
        println("=listOrderTime===%s",resp);
        if (resp == null) {
            System.out.println("请求出错，请查看代码");
            return;
        }
        if (resp.getEcode() == Constant.ERROR_SUCCEED) {
            List<TimeOrder> data = resp.getData();
            for (TimeOrder order : data) {
                int restSurplus = order.getRestSurplus();
                println("时间段:%s-%s 可预约名额:%s  剩余名额:%s", order.getOuatBeginTime(), order.getOuatEndTime(), order.getRestSum(), restSurplus);
                if (restSurplus > 0 && isAppointment && preference(outpName,corpCode, order.getOuatBeginTime())) {
					ConfirmBean bean = new ConfirmBean();
                    bean.setDepaId(order.getDepaId());
                    bean.setReusId(getReusId());
                    bean.setOuatId(order.getOuatId());
                    bean.setDate(order.getRestDate().substring(0, order.getRestDate().indexOf(" ")));
                    bean.setVaccCodes(vaccCode);
                    bean.setCorpCode(corpCode);
					confirmOrder(bean);
                }
            }
        }
    }

    //增加筛选规则
    private static boolean preference(String outpName,String corpCode,String time) {
        if (!Config.isOpen) return true;
        String[] name = Config.PREFER_PLACE.split(",");
        boolean nameFilter = false;
        for (String s:name){
            if (outpName.contains(s)) {
                nameFilter = true;
                break;
            }
        }
        return nameFilter && (corpCode.equals(Config.PREFER_VACCINE_CODE_FIRST) || corpCode.equals(Config.PREFER_VACCINE_CODE_SECOND)) && time.contains(Config.PREFER_TIME);
    }

    /**
     * 确认预约
     *
     * @param bean
     * @throws IOException
     */
    private static void confirmOrder(ConfirmBean bean) throws IOException {
        String url = "https://xgsz.szcdc.net/crmobile/reservation/saveAppointment";
        MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
        String params = new Gson().toJson(bean);
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, params);
        TypeToken<Resp<List<ReseIdBean>>> token = new TypeToken<Resp<List<ReseIdBean>>>() {};
        Resp<List<ReseIdBean>> listResp = postRequest(url, body, token);
        if (listResp == null) return;
        if (listResp.getEcode() == Constant.ERROR_SUCCEED){
            isAppointment = false;
            List<ReseIdBean> data = listResp.getData();
            ReseIdBean reseIdBean = data.get(0);
            getReservationById(reseIdBean.getReseId());
            return;
        }
        println("============%s=============",listResp.getMsg());
    }

    public static Resp<UserInfoBean> getUserInfo(){
        String url = "https://xgsz.szcdc.net/crmobile/registerUser/getUserInfo";
        TypeToken<Resp<UserInfoBean>> token = new TypeToken<Resp<UserInfoBean>>() {};
        Resp<UserInfoBean> listResp = null;
        try {
            listResp = getRequest(url,token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (listResp == null) return null;
        if (listResp.getEcode() == Constant.ERROR_SUCCEED){
            UserInfoBean data = listResp.getData();
            List<UserInfoBean.RegisterUserDTO> registerUser = data.getRegisterUser();
            reusId = registerUser.get(0).getReusId();
        }
        return listResp;
    }

    private static void getReservationById(String reseId) throws IOException {
        String url  = String.format("https://xgsz.szcdc.net/crmobile/reservation/getReservationByID?reseId=%s",reseId);
        TypeToken<Resp<ReservationBean>> token = new TypeToken<Resp<ReservationBean>>() {};
        Resp<ReservationBean> resp = getRequest(url, token);
        if(resp == null) return;
        if (resp.getEcode() == Constant.ERROR_SUCCEED){
            ReservationBean data = resp.getData();
            println("=============预约成功=============");
            println("预约码:  %s",data.getReseCheckCode());
            println("预约疫苗:  %s",data.getVaccNames());
            println("疫苗厂商:  %s",data.getCorpName());
            println("接种门诊:  %s",data.getDepaName());
            println("门诊地址:  %s",data.getOutpAddress());
            println("预约时间:  %s",data.getReseStartTime());
            println("接 种 人:  %s",data.getReusTrueName());
            println("================================");

            String desp = String.format(
                    "=============预约成功=============<br/>"+
                    "预约码:  %s <br/>" +
                    "预约疫苗:  %s <br/>" +
                    "疫苗厂商:  %s <br/>" +
                    "接种门诊:  %s <br/>" +
                    "门诊地址:  %s <br/>" +
                    "预约时间:  %s <br/>" +
                    "接 种 人:  %s <br/>" +
                    "=======================================",
                    data.getReseCheckCode(),
                    data.getVaccNames(),
                    data.getCorpName(),
                    data.getDepaName(),
                    data.getOutpAddress(),
                    data.getReseStartTime(),
                    data.getReusTrueName()
                    );

            String title = "预约成功";
            notifyMsg(title,desp);
        }
    }

    private static String getReusId(){
        if (StringUtils.isEmpty(reusId)) getUserInfo();
        return reusId;
    }

    private static void println(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    private static void test() {
        String url = String.format("https://xgsz.szcdc.net/crmobile/reservation/saveAppointment");
    }


}
