package com.example.myapplication.utils

object Constants {
    const val TAG : String = "로그"
}

enum class SEARCH_TYPE {
    PHOTO,
    USER
}

enum class RESPONSE_STATE {
    OKAY,
    FAIL
}

object API {
    const val AI_BASE_URL : String = "http://182.217.140.11:5000/"
    const val AI_WORK : String = "work"
    const val API_URL : String = "http://182.217.140.11:8080/"
    const val Login : String = "account/login"
    const val Sign : String = "account/sign"
    const val Report : String = "report/report_num"
    const val Get_Report : String = "report/recent_list"
    var AccessKey : String = ""
    var RefreshKey : String = ""
    var Uid : String = ""
    var pn : String = "01012345678"
    var idx : Int = 0
    var fragment : Int = 0
}
