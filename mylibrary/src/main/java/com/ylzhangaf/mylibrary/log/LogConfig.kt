package com.ylzhangaf.mylibrary.log

import com.ylzhangaf.mylibrary.log.formatter.StackTraceFormatter
import com.ylzhangaf.mylibrary.log.formatter.ThreadFormatter
import com.ylzhangaf.mylibrary.log.printer.LogPrinter

abstract class LogConfig {

    companion object {
        const val MAX_LEN = 512

        val threadFormatter = ThreadFormatter()
        val stackTraceFormatter = StackTraceFormatter()
    }

    /**
     * 获取全局默认tag
     */
    open fun getGlobalTag() : String {
        return "ylzhangaf_log"
    }

    /**
     * 是否启用logmonitor
     * true : 启用
     * false : 不启用
     */
    open fun isEnable() : Boolean {
        return true
    }

    var isIncludeThread : Boolean = false

    var stackTraceDepth : Int = 5

    var jsonParser : JsonParser? = null

    val printers = mutableListOf<LogPrinter>()

    /**
     * 初始化json解析器
     */
    open fun injectJsonParser(jsonParser : JsonParser?) : LogConfig {
        this.jsonParser = jsonParser
        return this
    }

    open fun includeThread(isInclude : Boolean) : LogConfig {
        isIncludeThread = isInclude
        return this
    }

    open fun setStackTraceDepth(stackTraceDepth : Int) : LogConfig {
        this.stackTraceDepth = stackTraceDepth
        return this
    }

    open fun setPrinters(printers : List<LogPrinter>) : LogConfig {
        this.printers.clear()
        this.printers.addAll(printers)
        return this
    }

    interface JsonParser {
        fun toJson(data : Any) : String
    }

}