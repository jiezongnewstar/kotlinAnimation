package com.xibei.kotlinanimation.util

import android.content.res.Resources
import android.util.TypedValue

class Util{


    companion object {
        public  fun dp2px(dp: Float) : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,Resources.getSystem().displayMetrics).toInt()

    }

}