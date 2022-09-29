package com.project.testkotlin

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.utils.API
import org.json.JSONArray
import org.json.JSONObject


class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_second, container, false)
        val list_item = mutableListOf<String>()
        val pf = context?.getSharedPreferences("test", Context.MODE_PRIVATE)
        var flag=0
        val data = arrayOf("Danger Message", "Safe Message")
        val pn = API.pn
        val MessageArray = mutableListOf<String>()

        if (pf?.contains(pn) == true){
            val temp = JSONArray(pf?.getString(pn,""))
            for (i in 0 until temp.length()){
                flag=0
                if (JSONObject(temp.getString(i)).getString("message_confirm")=="안전"
                    && JSONObject(temp.getString(i)).getString("url_confirm")=="안전"){
                    flag=1
                }
                var msg = JSONObject(temp.getString(i)).getString("message")
                MessageArray.add(msg + "\n\nURL 검사 결과 : "+JSONObject(temp.getString(i)).getString("url_confirm")
                    +"\n메세지 검사 결과 : " + JSONObject(temp.getString(i)).getString("message_confirm"))
                if (msg.length > 20) {
                    msg = JSONObject(temp.getString(i)).getString("message").substring(0,20)
                }
                list_item.add(msg+ "...\n" + data[flag])
            }
        }
        val pnText = view.findViewById<TextView>(R.id.pn)
        val itemlist = view.findViewById<ListView>(R.id.mainListView) //fragment에서 사용법
        val listviewadapter = ListViewAdapter(list_item)
        pnText.text = pn + "님의 메세지"
        itemlist.adapter = listviewadapter
        itemlist.setOnItemClickListener { parent, view, position, id ->
            val MessageDialog = AlertDialog.Builder(this.context)
            val ReportDialog = AlertDialog.Builder(this.context)
            val input = EditText(this.context)
            ReportDialog.setTitle(API.pn)
                .setMessage("\n"+MessageArray.get(position)+"\n")
                .setView(input)
                .setNegativeButton("확인",
                    DialogInterface.OnClickListener { dialog, id ->
                        Toast.makeText(this.context, "신고가 완료되었습니다.", Toast.LENGTH_SHORT).show()
                    })
                .setPositiveButton("취소",
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            MessageDialog.setTitle(API.pn)
                .setMessage(MessageArray.get(position))
                .setNegativeButton("확인",
                    DialogInterface.OnClickListener { dialog, id ->
                    })
                .setPositiveButton("신고",
                    DialogInterface.OnClickListener { dialog, id ->
                        ReportDialog.show()
                    })
            MessageDialog.show()
        }


        itemlist.adapter = listviewadapter


        view.findViewById<Button>(R.id.btn1).setOnClickListener{
            it.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            this.onDestroy()
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