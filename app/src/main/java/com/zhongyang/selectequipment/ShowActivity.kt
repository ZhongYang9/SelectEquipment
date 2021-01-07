package com.zhongyang.selectequipment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {

    private val mSwordCode = 1;//购买宝剑请求码
    private val mArrowCode = 2;//购买弓箭请求码
    private val mProgressBarMax = 1000//进度条最大值
    private val tag = "ShowActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        //接收数据
        getIntentData()
        //初始化控件
        initView()
        //初始化事件
        initEvent()
    }

    private fun initView() {
        //给进度条设置最大值
        pgb_attack.max = mProgressBarMax
        pgb_life.max = mProgressBarMax
        pgb_speed.max = mProgressBarMax
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //对返回来的数据进行判断处理
        when (requestCode) {
            mSwordCode -> if (resultCode == RESULT_OK) {
                //接收序列化数据
                val sword =
                    data?.getSerializableExtra("key_equipment_sword") as com.zhongyang.selectequipment.Equipment
                //更新数据
                updateData(sword)
            }
            mArrowCode -> {
                //接收序列化数据
                val arrow =
                    data?.getSerializableExtra("key_equipment_arrow") as com.zhongyang.selectequipment.Equipment
                //更新数据
                updateData(arrow)
            }
        }
    }

    private fun updateData(equipment: com.zhongyang.selectequipment.Equipment) {
        //获取当前进度条的值
        val attackData = pgb_attack.progress
        val lifeData = pgb_life.progress
        val speedData = pgb_speed.progress
        //设置进度条的值
        pgb_attack.progress = attackData + equipment.attack
        pgb_life.progress = lifeData + equipment.life
        pgb_speed.progress = speedData + equipment.speed
        //设置进度条文字显示内容
        tv_attack.text = pgb_attack.progress.toString()
        tv_life.text = pgb_life.progress.toString()
        tv_speed.text = pgb_speed.progress.toString()
        //处理进度条溢出
        if (pgb_attack.progress >= mProgressBarMax) {
            tv_attack.text = "MAX"
        }
        if (pgb_life.progress >= mProgressBarMax) {
            tv_life.text = "MAX"
        }
        if (pgb_speed.progress >= mProgressBarMax) {
            tv_speed.text = "MAX"
        }
    }

    private fun initEvent() {
        //逐日之弓点击事件
        ll_arrow.setOnClickListener {
            //跳转到弓箭Activity
            val intent = Intent(this, ArrowActivity::class.java)
            startActivityForResult(intent, mArrowCode)
        }
        //大宝剑点击事件
        ll_sword.setOnClickListener {
            //跳转到宝剑Activity
            val intent = Intent(this, SwordActivity::class.java)
            startActivityForResult(intent, mSwordCode)
        }
    }

    private fun getIntentData() {
        //通过Intent获取数据
        val userName = intent.getStringExtra("key_user_name")
        val password = intent.getStringExtra("key_pwd")
        //设置控件显示内容
        tv_show_userName.text = userName
        tv_show_pwd.text = password
    }
}