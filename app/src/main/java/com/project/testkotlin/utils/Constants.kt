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
    const val AI_BASE_URL : String = "http://10.0.2.2:5000/"
    const val AI_WORK : String = "work"
    const val API_URL : String = "http://10.0.2.2:8080/"
    const val Login : String = "account/login"
    var AccessKey : String = ""
    var RefreshKey : String = ""
    var Uid : String = ""
}
