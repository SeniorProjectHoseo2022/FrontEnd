package com.example.myapplication.retrofit
import android.util.Log
import com.example.myapplication.utils.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response
import com.example.myapplication.utils.Constants.TAG
class RetrofitManager {
    companion object {
        val instance = RetrofitManager()
    }

    private val AI_Retrofit : Retrofit_Interface? = Retrofit_Client.getClient(API.AI_BASE_URL)?.create(Retrofit_Interface::class.java)
    private val API_Retrofit : Retrofit_Interface? = Retrofit_Client.getClient(API.API_URL)?.create(Retrofit_Interface::class.java)

    fun AI_Request(text: String, uid: String?, pid: String?, completion:(String) -> Unit) {
        var text = text ?:""
        var uid = uid ?:""
        var pid = pid ?:""
        val call = AI_Retrofit?.work(text=text,uid=uid,pid=pid) ?: return
        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "Manager - Success ${response.raw()}")
                completion(response.body().toString())
            }
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "Manager - fail $t")
            }
        })
    }

    fun Login(id: String?, pw: String?, completion:(String) -> Unit) {
        var id = id ?:""
        var pw = pw ?:""
        val call = API_Retrofit?.Login(id=id, pw=pw) ?: return
        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "Manager - Success ${response.raw()}")
                completion(response.body().toString())
            }
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "Manager - fail $t")
            }
        })
    }

    fun sign(id: String?, pw: String?, pid: String, completion:(String) -> Unit) {
        var id = id ?:""
        var pw = pw ?:""
        var pid = pid ?:""
        val call = API_Retrofit?.Sign(id=id, pw=pw, pid=pid) ?: return
        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "Manager - Success ${response.raw()}")
                completion(response.body().toString())
            }
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "Manager - fail $t")
            }
        })
    }

    fun report(text: String?, pid: String, completion:(String) -> Unit) {
        var text = text ?:""
        var pid = pid ?:""
        val call = API_Retrofit?.Report(auth = API.AccessKey,text = text, pid = pid) ?: return
        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "Manager - Success ${response.raw()}")
                completion(response.body().toString())
            }
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "Manager - fail $t")
            }
        })
    }

    fun getReport(completion:(String) -> Unit) {
        val call = API_Retrofit?.GetReport() ?: return
        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "Manager - Success ${response.raw()}")
                completion(response.body().toString())
            }
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "Manager - fail $t")
            }
        })
    }
}