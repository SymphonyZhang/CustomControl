package com.symphony.customcontrol.view

import android.content.Context
import android.graphics.*
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import com.symphony.customcontrol.R

/**
 * @Author yx.zhang
 * @Date 2019/11/25-9:06
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
class CheckView: View {
    companion object{
        const val ANIM_NULL:Int = 0         //动画状态-没有
        const val ANIM_CHECK:Int = 1        //动画状态-开启
        const val ANIM_UNCHECK:Int = 2      //动画状态-结束
    }
    private lateinit var mContext: Context
    private var mWidth:Int = 0
    private var mHeight:Int = 0

    private lateinit var mPaint:Paint
    private lateinit var okBitmap: Bitmap

    private var animCurrrentPage:Int = -1       //当前页码
    private var animMaxPage:Int = 13            //总页数
    private var animDuration:Int = 500          //动画时长
    private var animState = ANIM_NULL       //动画状态
    private var isCheck = false             //是否只选中状态

    private lateinit var mHandler:Handler   //handler

    constructor(context: Context):this(context,null)

    constructor(context: Context, attrs: AttributeSet?):super(context,attrs){
        init(context)
    }

    private fun init(context:Context){
        mContext = context
        mPaint = Paint()
        mPaint.color = 0xFFFF5317.toInt()
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true

        okBitmap = BitmapFactory.decodeResource(mContext.resources, R.drawable.checkmark)

        mHandler = Handler{
            if(animCurrrentPage < animMaxPage && animCurrrentPage >= 0){
                invalidate()
                if(animState == ANIM_NULL){
                    false
                }
                if(animState == ANIM_CHECK){
                    animCurrrentPage++
                }else if(animState == ANIM_UNCHECK){
                    animCurrrentPage--
                }
                mHandler.sendEmptyMessageDelayed(0,(animDuration/animMaxPage).toLong())
            }else{
                if(isCheck){
                    animCurrrentPage = animMaxPage -1
                }else{
                    animCurrrentPage = -1
                }
                invalidate()
                animState = ANIM_NULL
            }
            false
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //移动坐标系到画布中央
        canvas.translate(mWidth.toFloat()/2,mHeight.toFloat()/2)
        //绘制背景圆形
        canvas.drawCircle(0f,0f,240f,mPaint)
        //得出图像边长
        var sideLength:Int = okBitmap.height
        //得到图像选区和实际绘制位置
        var src = Rect(sideLength*animCurrrentPage,0,sideLength*(animCurrrentPage+1),sideLength)
        var dst = Rect(-200,-200,200,200);
        //绘制
        canvas.drawBitmap(okBitmap,src,dst,null)
    }

    fun check(){
        println("checkView   on check!!!!")
        if(animState != ANIM_NULL || isCheck){
            return
        }
        animState = ANIM_CHECK
        animCurrrentPage = 0
        mHandler.sendEmptyMessageDelayed(0,(animDuration/animMaxPage).toLong())
        isCheck = true
    }

    fun unCheck(){
        println("checkView   uncheck!!!!")
        if(animState != ANIM_NULL || (!isCheck)){
            return
        }
        animState = ANIM_UNCHECK
        animCurrrentPage = animMaxPage -1
        mHandler.sendEmptyMessageDelayed(0,(animDuration/animMaxPage).toLong())
        isCheck = false
    }

    /**
     * 设置动画时长
     * @param animDuration
     */
    fun setAnimDuration(animDuration:Int){
        if(animDuration <= 0){
            return
        }
        this.animDuration = animDuration
    }

    /**
     * 设置背景圆形颜色
     * @param color
     */
    override fun setBackgroundColor(color:Int){
        mPaint.color = color
    }
}