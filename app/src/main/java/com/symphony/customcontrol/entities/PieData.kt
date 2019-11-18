package com.symphony.customcontrol.entities

/**
 * @Author yx.zhang
 * @Date 2019/11/14-10:36
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
data class PieData(val name:String,val value:Float){
    var percentage:Float = 0f
    var color:Int = 0
    var angle:Float =0f
}