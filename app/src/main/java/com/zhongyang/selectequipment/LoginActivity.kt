package com.zhongyang.selectequipment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //初始化事件
        initEvent()
    }

    private fun initEvent() {
        //注册按钮点击事件
        ll_registerBtn.setOnClickListener {
            //获取输入框内容
            val userName = et_userName.text.toString()
            val password = et_pwd.text.toString()
            //注册逻辑
            registerLogic(userName, password)
        }
    }

    private fun registerLogic(userName: String, password: String) {
        if (userName.isEmpty() || password.isEmpty()) {
            //对输入内容进行判空，若为空，则提示
            Toast.makeText(this, "请输入完整信息", Toast.LENGTH_SHORT).show()
        } else {
            //否则就进行跳转
            val intent = Intent(this, ShowActivity::class.java)
            //封装数据
            intent.putExtra("key_user_name", userName)
            intent.putExtra("key_pwd", password)
            //跳转
            startActivity(intent)
            //清空数据
            et_userName.setText("")
            et_pwd.setText("")
        }
    }
}