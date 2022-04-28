package com.ylzhangaf.mylibrary.log.formatter

import com.ylzhangaf.mylibrary.log.LogConfig

class StackTraceFormatter : LogFormatter<Array<StackTraceElement>> {
    override fun format(data: Array<StackTraceElement>, logConfig : LogConfig): String {
        if (data.isNullOrEmpty()) {
            return ""
        }

        return if (data.size == 1) {
            "\t-${data.first()}"
        } else {
            val realStackTrace = StackTraceLogic.getRealStackTrace(data, logConfig.ignorePackages)
            StackTraceLogic.cropStackTrace(realStackTrace.toTypedArray(), logConfig).joinToString("\n") { "\t-$it" }
        }


    }

    private object StackTraceLogic {
        /**
         * 裁剪堆栈信息
         */
        fun cropStackTrace(data: Array<StackTraceElement>, logConfig: LogConfig) : List<StackTraceElement>{
            return data.toMutableList().subList(0, if (data.size > logConfig.stackTraceDepth) logConfig.stackTraceDepth else data.size)
        }

        /**
         * 过滤指定包名后获取最新的堆栈信息
         */
        fun getRealStackTrace(data : Array<StackTraceElement>, ignorePackages : List<String>) : List<StackTraceElement>{
            return data.filterNot {
                val clazzName = it.className
                ignorePackages.any { ignorePackage -> clazzName.startsWith(ignorePackage) }
            }.toList()
        }
    }
}