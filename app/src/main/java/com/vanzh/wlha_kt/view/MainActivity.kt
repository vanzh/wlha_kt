package com.vanzh.wlha_kt.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.vanzh.wlha_kt.R
import com.vanzh.wlha_kt.databinding.ActivityMainBinding
import com.vanzh.wlha_kt.vm.LoginModel

class MainActivity : AppCompatActivity() {
    var mBind: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBind!!.loginModel = LoginModel()
    }


}
