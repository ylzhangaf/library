package com.ylzhangaf.mylibrary.log

import com.ylzhangaf.mylibrary.log.formatter.StackTraceFormatter
import com.ylzhangaf.mylibrary.log.formatter.ThreadFormatter
import com.ylzhangaf.mylibrary.log.printer.LogPrinter

abstract class LogConfig {

    companion object {
        const val MAX_LEN = 512
        const val DEFAULT_STACK_TRACE_DEPTH = 5

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

    /**
     * 是否包含线程日志
     */
    var isIncludeThread : Boolean = false

    /**
     * 堆栈深度 默认为5
     */
    var stackTraceDepth : Int = DEFAULT_STACK_TRACE_DEPTH

    /**
     * json解析实体
     */
    var jsonParser : JsonParser? = null

    /**
     * 日志打印器列表
     */
    val printers = mutableListOf<LogPrinter>()

    /**
     * 忽略包名
     */
    val ignorePackages : MutableList<String> = mutableListOf()

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

    open fun addIgnorePackage(ignorePackage : String) : LogConfig {
        this.ignorePackages.takeIf { !it.contains(ignorePackage) }?.add(ignorePackage)
        return this
    }

    open fun addIgnorePackages(ignorePackages : List<String>) : LogConfig {
        this.ignorePackages.addAll(ignorePackages.filterNot { ignorePackage ->
            this.ignorePackages.contains(ignorePackage) })
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