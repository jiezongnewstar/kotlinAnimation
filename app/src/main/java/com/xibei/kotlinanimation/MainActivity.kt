package com.xibei.kotlinanimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xibei.kotlinanimation.view.HistogramView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val histogramView = HistogramView(this)
        setContentView(histogramView)

    }
}
