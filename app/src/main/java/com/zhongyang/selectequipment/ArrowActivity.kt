package com.zhongyang.selectequipment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_arrow.*

class ArrowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arrow)
        //初始化控件
        initView()
    }

    private fun initView() {
        //实例化bean类
        val arrow = Equipment()
        //封装数据
        arrow.attack = 80
        arrow.life = 20
        arrow.speed = 50
        //设置控件显示内容
        tv_arrowLife.text = "+${arrow.life}"
        tv_arrowAttack.text = "+${arrow.attack}"
        tv_arrowSpeed.text = "+${arrow.speed}"
        //设置点击事件
        initEvent(arrow)
    }

    private fun initEvent(arrow: Equipment) {
        ll_buyArrow.setOnClickListener {
            val intent = Intent()
            intent.putExtra("key_equipment_arrow", arrow)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}