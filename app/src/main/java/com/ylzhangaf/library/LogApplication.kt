package com.ylzhangaf.library

import android.app.Application
import com.ylzhangaf.mylibrary.log.LogConfig
import com.ylzhangaf.mylibrary.log.LogManager

class LogApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        LogManager.init(object : LogConfig() {
            override fun getGlobalTag(): String {
                return "com.ylzhangaf.library.LogApplication"
            }
        })
    }

}