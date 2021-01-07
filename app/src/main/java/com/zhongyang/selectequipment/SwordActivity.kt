package com.zhongyang.selectequipment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sword.*

class SwordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sword)
        //初始化控件
        initView()
    }

    private fun initEvent(sword: Equipment) {
        //购买大宝剑按钮点击事件
        ll_buySword.setOnClickListener {
            //返回数据
            returnData(sword)
        }
    }

    private fun returnData(sword: Equipment) {
        val intent = Intent()//实例化Intent类
        intent.putExtra("key_equipment_sword", sword)//封装数据
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun initView() {
        //实例化bean类
        val sword = Equipment()
        //封装数据
        sword.life = 20
        sword.attack = 100
        sword.speed = 10
        //设置控件显示内容
        tv_swordLife.text = "+${sword.life}"
        tv_swordAttack.text = "+${sword.attack}"
        tv_swordSpeed.text = "+${sword.speed}"
        //初始化事件
        initEvent(sword)
    }
}