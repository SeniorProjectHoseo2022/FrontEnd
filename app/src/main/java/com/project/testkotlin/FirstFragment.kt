package com.project.testkotlin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.navigation.findNavController


class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val list_item = mutableListOf<String>()
        list_item.add("010-1234-5678" + "\n 보이스피싱 의심 번호입니다")
        list_item.add("010-9876-5432" + "\n 보이스피싱 의심 번호입니다")
        list_item.add("010-1111-2222" + "\n 대출안내 의심 번호입니다")
        list_item.add("010-3333-4444" + "\n 불법게임, 도박 의심 번호입니다")
        list_item.add("010-5555-6666" + "\n 불법게임, 도박 의심 번호입니다")
        list_item.add("010-7777-8888" + "\n 불법게임, 도박 번호입니다")
        list_item.add("010-9999-0000" + "\n 보험안내 번호입니다")
        list_item.add("1234-5678" + "\n 보험안내 번호입니다")
        list_item.add("1600-1600" + "\n 보험안내 번호입니다")

        val itemlist = view.findViewById<ListView>(R.id.mainListView) //fragment에서 사용법
        val listviewadapter = ListViewAdapter(list_item)

        itemlist.adapter = listviewadapter

        view.findViewById<Button>(R.id.btn2).setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        view.findViewById<Button>(R.id.btn3).setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        view.findViewById<Button>(R.id.btn4).setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_fourthFragment)
        }

        return view
    }


}