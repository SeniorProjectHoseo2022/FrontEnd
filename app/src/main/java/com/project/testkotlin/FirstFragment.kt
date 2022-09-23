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
import com.example.myapplication.utils.API


class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val list_item = mutableListOf<String>()
        list_item.add("엄마" + "\n 아들 오늘 언제들어오니?")
        list_item.add("아빠" + "\n 엄마한테는 비밀이야.")
        list_item.add("내 친구" + "\n 이따 끝나고 피시방갈까?")
        list_item.add("1600-1600" + "\n 고객님께만 드리는 특별 쿠폰! 해당 지급번호를 입력하고, 와우 할인가를 만나보세요!")
        list_item.add("02)458-5123" + "\n 신규 고객 가입 무료! 바로 지원가능!")
        list_item.add("할아버지" + "\n 좋은 글, 좋은 사진 아는 지인에게만 보내세요!")
        list_item.add("동생" + "\n 오빠 나 고데기사게 3만원만 빌려줘")
        list_item.add("1234-5678" + "\n 무 료 광 고 제 거 링 크 참 조")
        list_item.add("010-1234-1234" + "\n 무료 유출 픽 배당 100배 보장 바로 접속하세요")
        val itemlist = view.findViewById<ListView>(R.id.mainListView) //fragment에서 사용법
        val listviewadapter = ListViewAdapter(list_item)

        itemlist.adapter = listviewadapter

        view.findViewById<Button>(R.id.btn2).setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            this.onDestroy()
        }

        view.findViewById<Button>(R.id.btn3).setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
            this.onDestroy()
        }

        view.findViewById<Button>(R.id.btn4).setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_fourthFragment)
            this.onDestroy()
        }

        return view
    }


}