package com.example.netmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.netmodule.service.UserServiceImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val service by lazy { UserServiceImpl() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mLoginBtn.setOnClickListener {
            requestLogin()
        }
    }

    private fun requestLogin() {
        if (mPhoneEt.text.toString().isNullOrEmpty()) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show()
            return
        }

        if (mPwdEt.text.toString().isNullOrEmpty()) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
            return
        }
        service.login(mPhoneEt.text.toString().trim(), mPwdEt.text.toString().trim())
    }
}