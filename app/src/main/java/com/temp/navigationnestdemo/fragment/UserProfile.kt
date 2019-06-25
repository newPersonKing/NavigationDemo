package com.temp.navigationnestdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.temp.navigationnestdemo.R

class UserProfile : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_user_profile, container, false)

        val name = arguments?.getString("userName") ?: "Ali Connors"/*获取参数*/
        view.findViewById<TextView>(R.id.profile_user_name).text = name
        return view
    }
}