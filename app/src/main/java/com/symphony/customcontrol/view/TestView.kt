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
    //宽高
    private var mWidth:Int = 0
    private var mHeight:Int = 0

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
        mPaint.strokeWidth = 10f            //设置画笔宽度为10px
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight =h
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
        /*mPaint.color = Color.BLACK
        canvas.translate(200f,200f)
        canvas.drawCircle(0f,0f,100f,mPaint)

        mPaint.color = Color.BLUE
        canvas.translate(200f,200f)
        canvas.drawCircle(0f,0f,100f,mPaint)*/

        /**
         * scale 缩放
         *
         * 1. public void scale(float sx,float sy)                      //sx x轴缩放比你，sy y轴缩放比你  负数会翻转镜像成像
         *
         * 2. public void scale(float sx,float sy,float px,float py)    //sx x轴缩放比你，sy y轴缩放比你  负数会翻转镜像成像   px,py 控制缩放中心位置
         */
        //将坐标系原点移动到画布正中心
        /*canvas.translate(mWidth/2f,mHeight/2f)
        val rect = RectF(0f,-400f,400f,0f)      //矩形区域
        */
        /*mPaint.color = Color.BLACK                                        //绘制黑色矩形
        canvas.drawRect(rect,mPaint)
        */
        //canvas.scale(0.5f,0.5f/*,200f,-200f*/)                //绘制蓝色矩形
        //canvas.scale(0.5f,0.5f,200f,-200f)            //绘制蓝色矩形 添加了缩放中心
        /*canvas.scale(-0.5f,-0.5f,200f,0f)            //绘制蓝色矩形    负数比例会造成镜像翻转
        mPaint.color = Color.BLUE
        canvas.drawRect(rect,mPaint)
        */
        /*mPaint.style = Paint.Style.STROKE
        canvas.translate(mWidth/2f,mHeight/2f)
        val rect = RectF(-400f,-400f,400f,400f)
        for (i in 0 until 20) {
            canvas.scale(0.9f,0.9f)
            canvas.drawRect(rect,mPaint)
        }*/

        /**
         * rotate
         *
         * 1.public void rotate(float degrees)                      //degrees 旋转度数
         *
         * 2.public void rotate(float degrees,float px,float py)    //degrees 旋转度数   px,py 控制缩放中心位置
         */
        /*canvas.translate(mWidth/2f,mHeight/2f)
        val rect = RectF(0f,-400f,400f,0f)  //矩形
        mPaint.color = Color.BLACK                                      //绘制黑色矩形
        canvas.drawRect(rect,mPaint)

        //canvas.rotate(180f)                                 //旋转180度 默认旋转中心为原点
        canvas.rotate(180f,200f,0f)                                 //旋转180度 默认旋转中心为原点 添加了旋转中心
        mPaint.color = Color.BLUE                                    //绘制蓝色矩形
        canvas.drawRect(rect,mPaint)*/

        /*mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 5f
        canvas.translate(mWidth/2f,mHeight/2f)

        canvas.drawCircle(0f,0f,400f,mPaint)
        canvas.drawCircle(0f,0f,380f,mPaint)
        for (i in 0 until 36){
            canvas.drawLine(0f,380f,0f,400f,mPaint)
            canvas.rotate(10f)
        }*/
        /**
         * skew
         *
         * public void skew (float sx, float sy)
         */
         mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 3f
        canvas.translate(mWidth/2f,mHeight/2f)
        val rect = RectF(0f,0f,200f,200f)
        mPaint.color = Color.BLACK
        canvas.drawRect(rect,mPaint)

        canvas.skew(1f,0f)
        mPaint.color = Color.BLUE
        canvas.drawRect(rect,mPaint)

        canvas.skew(0f,1f)
        mPaint.color = Color.RED
        canvas.drawRect(rect,mPaint)
    }

}