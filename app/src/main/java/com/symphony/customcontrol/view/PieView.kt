package com.symphony.customcontrol.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.symphony.customcontrol.entities.PieData
import kotlin.math.min

/**
 * @Author yx.zhang
 * @Date 2019/11/14-11:01
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
class PieView: View {
    //颜色表
    private val mColors = arrayListOf<Int>(0xFFCCFF00.toInt(),0xFF6495ED.toInt(),0xFFE32636.toInt(),0xFF800000.toInt(),0xFF808000.toInt(),0xFFFF8C69.toInt(),0xFFE6B800.toInt(),0xFF7CFC00.toInt())
    //饼状图初始绘制角度
    private var mStartAngle:Float = 0f
    //数据
    private var mData:List<PieData>? = null
    //宽高
    private var mWidth:Int = 0
    private var mHeight:Int = 0
    //画笔
    private val mPaint = Paint()

    constructor(context: Context):super(context)

    constructor(context: Context, attrs: AttributeSet):super(context,attrs){
        initPaint()
    }

    private fun initPaint(){
        mPaint.style = Paint.Style.FILL     //设置画笔模式为填充
        mPaint.isAntiAlias = true
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if(null == mData){
            return
        }
        var currentStartAngle:Float = mStartAngle                       //当前起始角度
        canvas.translate((mWidth/2).toFloat(),(mHeight/2).toFloat())    //将画布坐标原点移动到中心位置
        val r = (min(mWidth,mHeight) /2 * 0.8).toFloat()                //饼状图半径
        val rect = RectF(-r,-r,r,r)                                     //饼状图绘制区域

        for (pie in mData!!) {
            mPaint.color = pie.color
            canvas.drawArc(rect,currentStartAngle,pie.angle,true,mPaint)
            currentStartAngle += pie.angle
        }
    }

    /**
     * 设置起始角度
     */
    fun setStartAngle(mStartAngle:Float){
        this.mStartAngle = mStartAngle
        invalidate()                        //刷新
    }

    fun setData(mData:List<PieData>?){
        this.mData = mData
        initData(mData)
        invalidate()
    }

    private fun initData(mData:List<PieData>?){
        if(null == mData || mData.isEmpty()){       //如果数据有问题，直接返回
            return
        }
        var sumValue = 0f
        for (pie in mData){
            sumValue+=pie.value                     //计算所有数据的总和
        }

        var sumAngle = 0f
        for(i in mData.indices){
            var pie:PieData = mData[i]

            val percentage = pie.value/sumValue     //计算百分比
            val angle = percentage * 360            //计算对应的角度
            var j = i%mColors.size                  //设置颜色
            pie.color = mColors[j]
            pie.percentage = percentage             //记录百分比
            pie.angle = angle                       //记录角度大小

            sumAngle += angle

            println("angle  =====  ${pie.angle}")
        }
    }
}