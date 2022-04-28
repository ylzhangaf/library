package com.ylzhangaf.library

import android.app.Application
import com.google.gson.Gson
import com.ylzhangaf.mylibrary.log.LogConfig
import com.ylzhangaf.mylibrary.log.LogManager
import com.ylzhangaf.mylibrary.log.printer.ConsolePrinter

class LogApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        LogManager.init(object : LogConfig() {
            override fun getGlobalTag(): String {
                return "com.ylzhangaf.library.LogApplication"
            }
        }.injectJsonParser(object : LogConfig.JsonParser {
            override fun toJson(data: Any): String {
                return Gson().toJson(data)
            }
        }).setPrinters(mutableListOf(ConsolePrinter()))
            .setStackTraceDepth(7)
            .includeThread(true)
            .addIgnorePackage("com.ylzhangaf.mylibrary.log"))
    }

}