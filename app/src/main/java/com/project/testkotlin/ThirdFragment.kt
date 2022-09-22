package com.project.testkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.navigation.findNavController

class ThirdFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        var view =inflater.inflate(R.layout.fragment_third, container, false)

        val list_item3 = mutableListOf<String>()
        list_item3.add("1. 1644-9300" + "\n 휴대폰 판매 의심 번호입니다")
        list_item3.add("2. 02-6230-9064" + "\n 휴대폰 판매 의심 번호입니다")
        list_item3.add("3. 031-927-5521" + "\n 휴대폰 판매 의심 번호입니다")
        list_item3.add("4. 02-6949-4281" + "\n 사기전화 유도 의심 번호입니다")
        list_item3.add("5. 02-6470-1728" + "\n 사기전화 유도 의심 번호입니다")
        list_item3.add("6. 070-7077-2294" + "\n 설문조사 마케팅 의심 번호입니다")
        list_item3.add("7. 02-6196-2713" + "\n 설문조사 마케팅 의심 번호입니다")
        list_item3.add("8. 032-324-3540" + "\n 중고사기 의심 번호입니다")
        list_item3.add("9. 031-605-3078" + "\n 중고사기 의심 번호입니다")
        list_item3.add("10. 041-425-7527" + "\n 악성코드 유포 의심 번호입니다")


        val itemlist = view.findViewById<ListView>(R.id.mainListView) //fragment에서 사용법
        val listviewadapter = ListViewAdapter(list_item3)

        itemlist.adapter = listviewadapter

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