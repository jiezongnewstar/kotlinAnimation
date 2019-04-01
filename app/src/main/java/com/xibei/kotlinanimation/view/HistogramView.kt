package com.xibei.kotlinanimation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import com.xibei.kotlinanimation.util.Util.Companion.dp2px

class HistogramView (context: Context) : View(context) {

    val xDegree = dp2px(300f) //xMax坐标

    val yDegree = dp2px(200f) //YMax坐标

    val count = 10
//
    val width = ((xDegree - dp2px(30f) - dp2px(40f) - (dp2px(10f) * count)) / count).toFloat() //每个柱状的宽度

    val height = ((yDegree - dp2px(40f))/count).toFloat()  //每个柱状的高度

    val paint = Paint()

    var rectLeft = dp2px(40f)
    var rectRight = rectLeft+width
    var rectBottom = yDegree


    init {
        paint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(Color.BLACK)

        paint.color = Color.WHITE
        paint.strokeWidth = dp2px(2f).toFloat()

        canvas?.drawLine(dp2px(30f).toFloat(), dp2px(40f).toFloat(), dp2px(30f).toFloat(), yDegree.toFloat(),paint)
        canvas?.drawLine(dp2px(29f).toFloat(), yDegree.toFloat(), xDegree.toFloat(), yDegree.toFloat(),paint)
        //柱状图逻辑 阶梯向上

        for (i in 1..count){

            // 左 上 右 下

                canvas?.drawRect(Rect(rectLeft, ((count - i)*height).toInt()+ dp2px(40f), rectRight.toInt(),rectBottom),paint)
                rectLeft = (rectRight + dp2px(10f)).toInt()
                rectRight = rectLeft+width
        }




    }



}