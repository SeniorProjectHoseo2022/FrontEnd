package com.project.testkotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class FourthFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_fourth, container, false)

        val ReceiveSMSActivityIntent = Intent(context, ReceiveSMSActivity::class.java)
        val btn3: Button = view.findViewById(R.id.message_btn)

        btn3.setOnClickListener{
            startActivity(ReceiveSMSActivityIntent)
        }

        view.findViewById<Button>(R.id.btn1).setOnClickListener{
            it.findNavController().navigate(R.id.action_fourthFragment_to_firstFragment)
        }

        view.findViewById<Button>(R.id.btn2).setOnClickListener{
            it.findNavController().navigate(R.id.action_fourthFragment_to_secondFragment)
        }

        view.findViewById<Button>(R.id.btn3).setOnClickListener{
            it.findNavController().navigate(R.id.action_fourthFragment_to_thirdFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}