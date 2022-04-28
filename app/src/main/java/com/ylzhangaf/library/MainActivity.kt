package com.ylzhangaf.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ylzhangaf.mylibrary.log.LogConfig
import com.ylzhangaf.mylibrary.log.LogManager
import com.ylzhangaf.mylibrary.log.LogMonitor
import com.ylzhangaf.mylibrary.log.LogType
import com.ylzhangaf.mylibrary.log.printer.ConsolePrinter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvew_log).setOnClickListener {
            LogMonitor.log(LogType.E, "ylzhangaf", "281864",
                object : LogConfig() {}.injectJsonParser(LogManager.getInstance().getConfig().jsonParser)
                    .includeThread(true).setPrinters(mutableListOf(ConsolePrinter()))
                    .setStackTraceDepth(3))
        }
    }
}