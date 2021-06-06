package com.code.demo.kotlin

import com.code.demo.Constant
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class AppointMain {
    private var token: String = ""
    private var corpCode: String = ""
    private var areaCode: String = ""
    private var page:Int = 1
    private var pageSize:Int = 10
    private val client: OkHttpClient = OkHttpClient()

    fun start() {
        println("*********新冠疫苗预约助手**********")
        inputToken()
        getVaccineInfo()
        getAreaList()
        getCommunityHealthServiceList()
    }

    private fun getCommunityHealthServiceList() {
        getCommunityList()
    }

    private fun getCommunityList() {
        val url = "https://xgsz.szcdc.net/crmobile/outpatient/nearby"
        val body = FormBody.Builder()
                .add("areaCode", areaCode)
                .add("corpCode", corpCode)
                .add("outpName", "")
                .add("outpMapLongitude", "")
                .add("outpMapLatitude", "")
                .add("bactCode", "5601")//新冠疫苗代码
                .add("pageNum", page.toString())
                .add("numPerPage", pageSize.toString())
                .build()
        val typeToken = object :TypeToken<Resp<NearBy>>(){}
        val resp = postRequest(url,body,typeToken)
        if (resp?.ecode == Constant.ERROR_SUCCEED){
            var lists = resp.data.list;
            printNearByList(resp.data.total,lists)
        }
    }

    private fun printNearByList(total: String, lists: List<NearList>) {
        println("===========请选择社康序号===========")
        println("---接种点总数:${total}--当前页数:${page}--每页:${pageSize}条----翻页:(N下一页/P上一页)")

        for (index in lists.indices){
            println("${((page - 1) * pageSize) + index}. ${lists[index].outpName}")
        }
        var index = readLine().toString()
        when (index) {
            "N" -> {
                page = 1.coerceAtLeast(++page)
                getCommunityList()
            }
            "P" -> {
                page = 1.coerceAtLeast(--page)
                getCommunityList()
            }
            else -> {
                if (!index.matches("\\d+".toRegex()) || index.toInt() >= lists.size){
                    printNearByList(total,lists)
                    return
                }
            }
        }
    }


    private fun inputToken() {
        println("请输入当前用户的token:")
        token = readLine().toString()
        if (!token.isToken()) {
            println("当前token输入有误,请重新输入")
            inputToken()
        }
    }

    private fun getVaccineInfo() {
        val url = "https://xgsz.szcdc.net/crmobile/vaccine/getVaccineCorpList"
        val type = object : TypeToken<Resp<List<VaccineCorp>>>() {}
        var resp = getRequest(url, type)
        if (resp?.ecode == Constant.ERROR_SUCCEED) {
            printlnVaccineInfo(resp.data)
            return
        }
        println("请求出错，错误原因:${resp?.msg}")
    }

    private fun getAreaList() {
        var url = "https://xgsz.szcdc.net/crmobile/outpatient/getAreaList"
        val type = object : TypeToken<Resp<List<Area>>>() {}
        var resp = getRequest(url, type)
        if (resp?.ecode == Constant.ERROR_SUCCEED) {
            printAreaInfo(resp.data)
        }
    }

    private fun printAreaInfo(data: List<Area>) {
        println("===请输入需要预约的区域序号===")
        for (index in data.indices) {
            println("${index}. ${data[index].name}")
        }
        var index = readLine().toString()
        if (!index.matches("\\d+".toRegex()) || index.toInt() >= data.size) {
            println("输入的序号无效")
            printAreaInfo(data)
            return
        }
        areaCode = data[index.toInt()].value
    }


    private fun printlnVaccineInfo(corps: List<VaccineCorp>) {
        println("===请输入疫苗厂商序号===")
        for (vaccine in corps.indices) {
            println("${vaccine}. ${corps[vaccine].corpName}")
        }
        var index = readLine().toString()
        if (!index.matches("[0-9]".toRegex()) || index.toInt() >= corps.size) {
            println("输入的序号无效")
            printlnVaccineInfo(corps)
            return
        }
        val corp = corps[index.toInt()]
        corpCode = corp.corpCode
    }

    private fun <T> getRequest(url: String, typeToken: TypeToken<T>): T? {
        return toRequest(getRequest(url), typeToken)
    }

    private fun <T> postRequest(url: String,body: RequestBody, typeToken: TypeToken<T>): T? {
        return toRequest(postRequest(url,body),typeToken)
    }

    private fun <T> toRequest(request: Request, typeToken: TypeToken<T>): T? {
        val call = client.newCall(request)
        val response = call.execute()
        if (response.body == null) return null
        val body = response.body!!.string()
        return Gson().fromJson(body, typeToken.type)
    }

    private fun getRequest(url: String): Request {
        return prepareRequest(url, Http.GET, null)
    }

    private fun postRequest(url: String, body: RequestBody): Request {
        return prepareRequest(url, Http.POST, body)
    }

    private fun prepareRequest(url: String, type: Http, body: RequestBody?): Request {
        var builder = Request.Builder().url(url)
                .addHeader("token", token)
                .addHeader("appId", "app569d18f5")
                .addHeader("selfappid", "wx5402a9708b90332e")
                .addHeader("reservationtoken", "6e043ad0314b430aa13878cfa77847f4")
                .addHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Mobile Safari/537.36 Edg/91.0.864.37")
                .addHeader("accept", "application/json, text/plain, */*")
                .addHeader("accept-language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .addHeader("sec-ch-ua", " Not;A Brand ;v=99, Microsoft Edge;v=91, Chromium;v=91")
                .addHeader("sec-ch-ua-mobile", "?1")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-site", "same-origin")

        return when (type) {
            Http.GET -> builder.get().build()
            Http.POST, Http.PUT, Http.DELETE -> {
                val contentType = if (body is FormBody) "application/x-www-form-urlencoded" else "application/json;charset=UTF-8";
                builder.addHeader("content-type", contentType);
                builder.post(body!!).build()
            }
        }
    }

}

