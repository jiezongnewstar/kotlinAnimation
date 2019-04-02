package com.xibei.kotlinanimation.view

import android.animation.ObjectAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import com.xibei.kotlinanimation.R
import com.xibei.kotlinanimation.util.Util.Companion.dp2px

class MDEditText(context: Context,attributeSet: AttributeSet) : EditText(context,attributeSet) {

    private var isFloat = true   //控制是否展示浮动提示

    private var bounds = Rect()   //控件边界

    private val PADDING_SIZE = dp2px(8f)  //内填充大小

    private val TEXT_SIZE = dp2px(12f)  //文字大小

    private val paint = Paint()

    private var isShowAnimator = false   //是否展示动画

    private var objectAnimator: ObjectAnimator? = null

    private var fraction = 0   //动画进度

    private var animatorLength = dp2px(16f)

    private var typedArray:TypedArray = context.obtainStyledAttributes(attributeSet,R.styleable.MDEditText)

    init {

        isFloat = typedArray.getBoolean(R.styleable.MDEditText_isFloat,true)

        typedArray.recycle()

        paint.textSize = TEXT_SIZE.toFloat()
        paint.isAntiAlias = true

        onUseFloateChange()

        addTextChangedListener(object :TextWatcher{

            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (isFloat){
                    if (isShowAnimator&&TextUtils.isEmpty(s)){
                        isShowAnimator = false
                        doAnimation()?.start()
                    }else if (!isShowAnimator && !TextUtils.isEmpty(s)){
                        isShowAnimator = true
                        doAnimation()?.reverse()
                    }
                }
            }

        })


    }



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.alpha = fraction * 0xff
        canvas?.drawText(hint.toString(),
            0,hint.length,
            paddingLeft.toFloat(),
            (paddingTop - 8 +animatorLength*(1-fraction)).toFloat(),
            paint)

    }


    fun doAnimation(): ObjectAnimator? {

        if (objectAnimator==null){
            objectAnimator = ObjectAnimator.ofInt(MDEditText@this,"fraction",1,0)
        }
        return objectAnimator
    }


    fun setFraction(fraction : Int){
        this.fraction = fraction
        invalidate()
    }


    fun getFraction() :Int{
        return  fraction
    }


    //是否浮动
    fun setFloat(isFloat: Boolean){
        if (this.isFloat!=isFloat){
            this.isFloat = isFloat
            onUseFloateChange()
        }
    }

    fun onUseFloateChange(){
        background.getPadding(bounds)
        if (isFloat) {
            setPadding(paddingLeft, bounds.top + TEXT_SIZE + PADDING_SIZE, paddingRight, paddingBottom)
        }else{
            setPadding(paddingLeft, bounds.top, paddingRight, paddingBottom)
        }
    }

}