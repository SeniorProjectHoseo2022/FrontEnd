package com.example.myapplication.retrofit

import com.example.myapplication.utils.API
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.*

interface Retrofit_Interface {
    @GET(API.AI_WORK)
    fun work(@Query("text") text: String,
             @Query("uid") uid: String,
             @Query("pid") pid: String) : Call<JsonElement>
    @FormUrlEncoded
    // @Header("Authorization") auth : String
    @POST(API.Login)
    fun Login(@Field("id") id :String,
              @Field("pw") pw :String
    ) : Call<JsonElement>
}
