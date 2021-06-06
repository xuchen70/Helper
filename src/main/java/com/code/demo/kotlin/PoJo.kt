package com.code.demo.kotlin
import com.google.gson.annotations.SerializedName

data class VaccineCorp(
    @SerializedName("corpCode")
    var corpCode: String,
    @SerializedName("corpEditTime")
    var corpEditTime: String,
    @SerializedName("corpEname")
    var corpEname: String,
    @SerializedName("corpFullName")
    var corpFullName: String,
    @SerializedName("corpId")
    var corpId: String,
    @SerializedName("corpName")
    var corpName: String,
    @SerializedName("corpUse")
    var corpUse: Int
)

data class NearBy(
    @SerializedName("endRow")
    var endRow: Int,
    @SerializedName("hasNextPage")
    var hasNextPage: Boolean,
    @SerializedName("hasPreviousPage")
    var hasPreviousPage: Boolean,
    @SerializedName("isFirstPage")
    var isFirstPage: Boolean,
    @SerializedName("isLastPage")
    var isLastPage: Boolean,
    @SerializedName("list")
    var list: List<NearList>,
    @SerializedName("navigateFirstPage")
    var navigateFirstPage: Int,
    @SerializedName("navigateLastPage")
    var navigateLastPage: Int,
    @SerializedName("navigatePages")
    var navigatePages: Int,
    @SerializedName("nextPage")
    var nextPage: Int,
    @SerializedName("pageNum")
    var pageNum: Int,
    @SerializedName("pageSize")
    var pageSize: Int,
    @SerializedName("pages")
    var pages: Int,
    @SerializedName("prePage")
    var prePage: Int,
    @SerializedName("size")
    var size: Int,
    @SerializedName("startRow")
    var startRow: Int,
    @SerializedName("total")
    var total: String
)

data class NearList(
    @SerializedName("areaId")
    var areaId: String,
    @SerializedName("areaName")
    var areaName: String,
    @SerializedName("corpCode")
    var corpCode: String,
    @SerializedName("corpName")
    var corpName: String,
    @SerializedName("depaCode")
    var depaCode: String,
    @SerializedName("depaId")
    var depaId: String,
    @SerializedName("nums")
    var nums: Int,
    @SerializedName("orderNumber")
    var orderNumber: Int,
    @SerializedName("outHolidaySkip")
    var outHolidaySkip: Int,
    @SerializedName("outLarge")
    var outLarge: Int,
    @SerializedName("outPreDay")
    var outPreDay: Int,
    @SerializedName("outpAddress")
    var outpAddress: String,
    @SerializedName("outpCreatedTime")
    var outpCreatedTime: String,
    @SerializedName("outpDay")
    var outpDay: String,
    @SerializedName("outpIntroduction")
    var outpIntroduction: String,
    @SerializedName("outpMapLatitude")
    var outpMapLatitude: Double,
    @SerializedName("outpMapLongitude")
    var outpMapLongitude: Double,
    @SerializedName("outpName")
    var outpName: String,
    @SerializedName("outpNoticeContent")
    var outpNoticeContent: String,
    @SerializedName("outpPhone")
    var outpPhone: String,
    @SerializedName("outpServiceTime")
    var outpServiceTime: String,
    @SerializedName("outpStockcreatedDate")
    var outpStockcreatedDate: String,
    @SerializedName("outpUpdatedTime")
    var outpUpdatedTime: String,
    @SerializedName("outpUse")
    var outpUse: Int,
    @SerializedName("outpWorkMode")
    var outpWorkMode: Int,
    @SerializedName("outpZipCode")
    var outpZipCode: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("stock")
    var stock: Int,
    @SerializedName("vcinUse")
    var vcinUse: Int
)

data class Area(
    @SerializedName("NAME")
    var name: String,
    @SerializedName("PARENT")
    var parent: String,
    @SerializedName("VALUE")
    var value: String
)

data class Resp<T>(
    @SerializedName("data")
    var data: T,
    @SerializedName("ecode")
    var ecode: Int,
    @SerializedName("msg")
    var msg: String
)
