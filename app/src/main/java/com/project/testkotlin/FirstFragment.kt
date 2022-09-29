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
import androidx.navigation.fragment.findNavController
import com.example.myapplication.utils.API
import org.json.JSONObject
import java.util.*


class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val list_item = mutableListOf<String>()

        val pf = context?.getSharedPreferences("test", Context.MODE_PRIVATE)
        val numbers = mutableListOf<String>()

        if (pf?.contains("pns") == true){
            val json = JSONObject(pf?.getString("pns",""))
            val pn = json.keys()
            while(pn.hasNext()){
                val key = pn.next().toString()
                var msg = json.getString(key).toString()
                if (msg.length > 20)
                    msg = msg.substring(0,20) + "..."
                list_item.add(key+"\n"+msg)
                numbers.add(key)
            }
        }

        val itemlist = view.findViewById<ListView>(R.id.mainListView) //fragment에서 사용법
        val listviewadapter = ListViewAdapter(list_item)

        itemlist.adapter = listviewadapter
        itemlist.setOnItemClickListener { parent, view, position, id ->
            API.pn = numbers.get(position)
            this.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            this.onDestroy()
        }
        return view
    }


}