package com.project.testkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.navigation.findNavController
import com.example.myapplication.utils.API


class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_second, container, false)

        val list_item2 = mutableListOf<String>()
        list_item2.add("010-1234-5678" + "\n 보이스피싱 의심 번호입니다" + API.AccessKey)
        list_item2.add("010-9876-5432" + "\n 보이스피싱 의심 번호입니다" + API.RefreshKey)
        list_item2.add("010-1111-2222" + "\n 대출안내 의심 번호입니다" + API.Uid)
        list_item2.add("010-3333-4444" + "\n 불법게임, 도박 의심 번호입니다")
        list_item2.add("010-5555-6666" + "\n 불법게임, 도박 의심 번호입니다")
        list_item2.add("010-7777-8888" + "\n 불법게임, 도박 번호입니다")
        list_item2.add("010-9999-0000" + "\n 보험안내 번호입니다")
        list_item2.add("1234-5678" + "\n 보험안내 번호입니다")
        list_item2.add("1600-1600" + "\n 보험안내 번호입니다")


        val itemlist = view.findViewById<ListView>(R.id.mainListView) //fragment에서 사용법
        val listviewadapter = ListViewAdapter(list_item2)

        itemlist.adapter = listviewadapter


        view.findViewById<Button>(R.id.btn1).setOnClickListener{
            it.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        view.findViewById<Button>(R.id.btn3).setOnClickListener{
            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment3)
        }

        view.findViewById<Button>(R.id.btn4).setOnClickListener{
            it.findNavController().navigate(R.id.action_secondFragment_to_fourthFragment)
        }



        return view
    }

}