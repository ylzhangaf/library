package com.ylzhangaf.mylibrary.log

object LogMonitor {

    fun logV(content: Any) {
        log(LogType.V, content)
    }

    fun logV(tag: String, content: Any) {
        log(LogType.V, tag, content)
    }

    fun logE(content: Any) {
        log(LogType.E, content)
    }

    fun logE(tag: String, content: Any) {
        log(LogType.E, tag, content)
    }

    fun logI(content: Any) {
        log(LogType.I, content)
    }

    fun logI(tag: String, content: Any) {
        log(LogType.I, tag, content)
    }

    fun logD(content: Any) {
        log(LogType.D, content)
    }

    fun logD(tag: String, content: Any) {
        log(LogType.D, tag, content)
    }

    fun log(@LogType.TYPE type: Int, content: Any) {
        log(type, LogManager.getInstance().getConfig().getGlobalTag(), content)
    }

    fun log(@LogType.TYPE type: Int, tag: String, content: Any) {
        log(type, tag, content, LogManager.getInstance().getConfig())
    }

    fun log(@LogType.TYPE type: Int, tag: String, content: Any, config: LogConfig) {
        if (!config.isEnable()) {
            return
        }

        val strBuilder = StringBuilder()
        if (config.isIncludeThread) {
            val threadInfo = LogConfig.threadFormatter.format(Thread.currentThread(), config)
            strBuilder.append("\nThreadInfo: $threadInfo")
        }

        if (config.stackTraceDepth > 0) {
            val stackTraceInfo = LogConfig.stackTraceFormatter.format(Throwable().stackTrace, config)
            strBuilder.append("\nStackTraceInfo: \n$stackTraceInfo")
        }

        val contentStr = parseContent(content, config)
        strBuilder.append("\nContent: \n$contentStr")

        val printers = config.printers
        printers.forEach {
            it.print(config, type, tag, strBuilder.toString())
        }
    }

    private fun parseContent(content: Any, logConfig: LogConfig): String {
        val jsonParser = logConfig.jsonParser
        if (jsonParser != null) {
            return jsonParser.toJson(content)
        }

        return content.toString()
    }

}