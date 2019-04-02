package com.xibei.kotlinanimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        /**
         * 所有的自定义View 都在view 目录下，看效果就放开要看的效果的注释，关闭已经打开的注释就好了
         */

        //柱状图
        //setContentView(HistogramView(this))

        //---------------------------------------

        //MDEditText
        setContentView(R.layout.activity_main)
        //---------------------------------------

    }
}
