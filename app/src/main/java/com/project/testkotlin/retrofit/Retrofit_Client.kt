package com.example.myapplication.retrofit

import android.util.Log
import com.example.myapplication.utils.Constants.TAG
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_Client {
    private var retrofitClient: Retrofit? = null
//    private lateinit var retrofitClient: Retrofit
    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG, "called")

        retrofitClient = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofitClient
    }
}