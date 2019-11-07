package com.symphony.customcontrol.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
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
        /*canvas.drawPoint(200f,200f,mPaint)        //在坐标(200,200)位置绘制一个点
        canvas.drawPoints(floatArrayOf(500f,500f,500f,600f,500f,700f),mPaint)*/
        /**
         * drawLine
         * drawLines
         */
        //canvas.drawLine(300f,300f,500f,600f,mPaint)
        //canvas.drawLines(floatArrayOf(100f,200f,200f,200f,100f,300f,200f,300f),mPaint)
        /**
         * 绘制矩形
         *
         * drawRect  或者搭配 Rect 或者搭配 RectF
         *
         * 确定一个矩形最少需要四个数据，就是对角线的两个点的坐标值，这里一般采用左上角和右下角的两个点的坐标
         *
         * Rect是int(整形)的，而RectF是float(单精度浮点型)的
         */
        //1.第一种
        //canvas.drawRect(100f,100f,800f,400f,mPaint)
        //2.第二种
        /*val rect = Rect(100,100,800,400)
        canvas.drawRect(rect,mPaint)*/
        //3.第三种
        /*val rectF = RectF(100f,100f,800f,400f)
        canvas.drawRect(rectF,mPaint)*/
        /**
         * 绘制圆角矩形
         *
         * drawRoundRect
         *
         * 第二种方法在API21的时候才添加上，所以我们一般使用的都是第一种。
         *
         * 圆角矩形的角实际上不是一个正圆的圆弧，而是椭圆的圆弧，这里的两个参数实际上是椭圆的两个半径
         */
        //1.第一种
        val rectF = RectF(100f,100f,800f,400f)
        canvas.drawRoundRect(rectF,30f,30f,mPaint)
        //2.第二种
        canvas.drawRoundRect(100f,100f,800f,400f,30f,30f,mPaint)

    }

}