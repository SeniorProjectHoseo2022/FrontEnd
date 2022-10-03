package com.project.testkotlin

import android.os.Bundle
import android.telephony.PhoneNumberUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.navigation.findNavController
import com.example.myapplication.retrofit.RetrofitManager
import com.example.myapplication.utils.API
import org.json.JSONArray
import org.json.JSONObject

class ThirdFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        var view =inflater.inflate(R.layout.fragment_third, container, false)

        val list_item3 = mutableListOf<String>()

        RetrofitManager.instance.getReport()
        { responseBody ->
            val Data = JSONObject(responseBody)
            val msg = Data.getString("message")
            if (msg == "404") {
            }else {
                var tempData = JSONArray(Data.getString("text"))
                for (i:Int in 1 until tempData.length()){
                    val text = JSONObject(tempData[i].toString())
                    val res = PhoneNumberUtils.formatNumber(text.getString("num"),"KR")+
                            "\n" + text.getString("text")
                    list_item3.add(res)
                }
            }
            val itemlist = view.findViewById<ListView>(R.id.mainListView) //fragment에서 사용법
            val listviewadapter = ListViewAdapter(list_item3)

            itemlist.adapter = listviewadapter
        }

        view.findViewById<Button>(R.id.btn1).setOnClickListener{
            it.findNavController().navigate(R.id.action_thirdFragment_to_firstFragment2)
        }

        view.findViewById<Button>(R.id.btn2).setOnClickListener{
            it.findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
        }
        view.findViewById<Button>(R.id.btn4).setOnClickListener{
            it.findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
        }

        return view
    }

}