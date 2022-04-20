package com.ylzhangaf.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ylzhangaf.mylibrary.log.LogMonitor


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvew_log).setOnClickListener {
            LogMonitor.logD( "wdnmd")
        }
    }
}