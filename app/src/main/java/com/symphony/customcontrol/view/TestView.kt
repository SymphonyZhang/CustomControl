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
        /**
         * 画笔三种模式：
         * STOKE：描边
         * FILL： 填充
         * FILL_AND_STROKE： 描边加填充
         */
        mPaint.style = Paint.Style.FILL     //设置画笔模式为填充
        mPaint.strokeWidth = 2f            //设置画笔宽度为10px
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
        //canvas.drawLine(300f,300f,500f,600f,mPaint)                                       // 在坐标(300,300)(500,600)之间绘制一条直线
        //canvas.drawLines(floatArrayOf(100f,200f,200f,200f,100f,300f,200f,300f),mPaint)    // 绘制一组线 每四数字(两个点的坐标)确定一条线
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
        /*val rectF = RectF(100f,100f,800f,400f)
        canvas.drawRoundRect(rectF,30f,30f,mPaint)*/
        //2.第二种
        //canvas.drawRoundRect(100f,100f,800f,400f,30f,30f,mPaint)
        /**
         * 绘制椭圆
         *
         * drawOval
         *
         * 绘制椭圆实际上就是绘制一个矩形的内切图形
         */
        //1.第一种
        /*val rectF = RectF(100f,100f,800f,400f)
        canvas.drawOval(rectF,mPaint)*/
        //2.第二种
        //canvas.drawOval(100f,100f,800f,400f,mPaint)
        /**
         * 绘制圆
         *
         * drawCircle
         *
         * 绘制圆形有四个参数，前两个是圆心坐标，第三个是半径，最后一个是画笔。
         */
        //canvas.drawCircle(500f,500f,400f,mPaint)    // 绘制一个圆心坐标在(500,500)，半径为400 的圆。
        /**
         * 绘制圆弧
         *
         * startAngle //开始角度
         * sweepAngle //扫过角度
         * useCenter  //是否使用中心 画出的图形是否连接中心，true：连接中心形成扇形图形，false不连接中心，起始点和结束点相连
         *
         * 第一种
         * public void drawArc(@NonNull RectF oval, float startAngle, float sweepAngle, boolean useCenter, @NonNull Paint paint){}
         * 第二种
         * public void drawArc(float left, float top, float right, float bottom, float startAngle,float sweepAngle, boolean useCenter, @NonNull Paint paint) {}
         *
         */
        /*val rectF = RectF(100f,100f,800f,800f)
        //绘制背景矩形
        mPaint.color = Color.GRAY
        canvas.drawRect(rectF,mPaint)

        //绘制圆弧
        mPaint.color = Color.BLUE
        canvas.drawArc(rectF,0f,270f,true,mPaint)*/

        /**
         * Paint设置
         */
        /*mPaint.color = Color.BLUE
        mPaint.strokeWidth = 40f
        //1.描边
        mPaint.style = Paint.Style.STROKE
        canvas.drawCircle(200f,200f,100f,mPaint)
        //2.填充
        mPaint.style = Paint.Style.FILL
        canvas.drawCircle(200f,500f,100f,mPaint)
        //3.描边加填充
        mPaint.style = Paint.Style.FILL_AND_STROKE
        canvas.drawCircle(200f,800f,100f,mPaint)*/

        /**
         * translate 画布位移
         */
        mPaint.color = Color.BLACK
        canvas.translate(200f,200f)
        canvas.drawCircle(0f,0f,100f,mPaint)

        mPaint.color = Color.BLUE
        canvas.translate(200f,200f)
        canvas.drawCircle(0f,0f,100f,mPaint)
    }

}