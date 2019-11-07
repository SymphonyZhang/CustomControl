package com.symphony.customcontrol.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @Author yx.zhang
 * @Date 2019/11/6-17:43
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
class TestView: View {

    private val mPaint = Paint()

    constructor(context: Context):super(context)

    constructor(context: Context,attrs: AttributeSet):super(context,attrs){
        initPaint()
    }

    private fun initPaint(){
        mPaint.color = Color.BLACK          //设置画笔颜色
        mPaint.style = Paint.Style.FILL     //设置画笔模式为填充
        mPaint.strokeWidth = 10f            //设置画笔宽度为10px
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        /**
         * drawColor
         */
        //canvas.drawColor(Color.BLUE)                    //画布绘制蓝色
        /**
         * drawPoint
         * drawPoints
         */
//        canvas.drawPoint(200f,200f,mPaint)        //在坐标(200,200)位置绘制一个点
//        canvas.drawPoints(floatArrayOf(500f,500f,500f,600f,500f,700f),mPaint)
        /**
         * drawLine
         * drawLines
         */
        canvas.drawLine(300f,300f,500f,600f,mPaint)
        canvas.drawLines(floatArrayOf(100f,200f,200f,200f,100f,300f,200f,300f),mPaint)
    }

}