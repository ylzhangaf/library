package com.ylzhangaf.mylibrary.log

import android.util.Log

object LogMonitor {

    fun logV(content : Any) {
        log(LogType.V, content)
    }

    fun logV(tag : String, content : Any) {
        log(LogType.V, tag, content)
    }

    fun logE(content : Any) {
        log(LogType.E, content)
    }

    fun logE(tag : String, content : Any) {
        log(LogType.E, tag, content)
    }

    fun logI(content : Any) {
        log(LogType.I, content)
    }

    fun logI(tag : String, content : Any) {
        log(LogType.I, tag, content)
    }

    fun logD(content : Any) {
        log(LogType.D, content)
    }

    fun logD(tag : String, content : Any) {
        log(LogType.D, tag, content)
    }

    fun log(@LogType.TYPE type : Int , content : Any) {
        log(type, LogManager.getInstance().getConfig().getGlobalTag(), content)
    }

    fun log(@LogType.TYPE type : Int, tag : String, content : Any) {
        log(type, tag, content, LogManager.getInstance().getConfig())
    }

    fun log(@LogType.TYPE type : Int, tag : String, content : Any, config : LogConfig) {
        if (!config.isEnable()) {
            return
        }

        val contentStr = parseContent(content)
        if (contentStr.isEmpty()) {
            return
        }

        Log.println(type, tag, contentStr)
    }

    fun parseContent(contnet : Any) : String {
        return "wdnmd"
    }

}