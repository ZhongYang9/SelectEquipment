package com.zhongyang.selectequipment

import java.io.Serializable

/**
 * @项目名称 SelectEquipment
 * @类名 Equipment
 * @包名 com.zhongyang.selectequipment
 * @创建时间 2021/1/6 19:44
 * @作者 钟阳
 * @描述 装备实体类，实现Serializable接口，方便Intent传值
 */
class Equipment : Serializable {

    var name: String = ""
    var attack: Int = 0
    var life: Int = 0
    var speed: Int = 0
}