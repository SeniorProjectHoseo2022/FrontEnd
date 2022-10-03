package com.example.myapplication.retrofit

import com.example.myapplication.utils.API
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.*

interface Retrofit_Interface {
    // @Header("Authorization") auth : String

    @GET(API.AI_WORK)
    fun work(@Query("text") text: String,
             @Query("uid") uid: String,
             @Query("pid") pid: String) : Call<JsonElement>

    @FormUrlEncoded
    @POST(API.Login)
    fun Login(@Field("id") id :String,
              @Field("pw") pw :String) : Call<JsonElement>

    @FormUrlEncoded
    @POST(API.Sign)
    fun Sign(@Field("id") id :String,
            @Field("pw") pw : String,
            @Field("pid") pid: String) : Call<JsonElement>

    @FormUrlEncoded
    @POST(API.Report)
    fun Report(@Header("Authorization") auth : String,
               @Field("text") text: String,
               @Field("pid") pid:String) : Call<JsonElement>

    @GET(API.Get_Report)
    fun GetReport() : Call<JsonElement>

}
