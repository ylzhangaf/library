package com.ylzhangaf.mylibrary.log.formatter

import com.ylzhangaf.mylibrary.log.LogConfig

class StackTraceFormatter : LogFormatter<Array<StackTraceElement>> {
    override fun format(data: Array<StackTraceElement>, config : LogConfig): String {
        if (data.isNullOrEmpty()) {
            return ""
        }

        return if (data.size == 1) {
            "\t-${data.first()}"
        } else {
            data.toMutableList().subList(0, if (data.size > config.stackTraceDepth) config.stackTraceDepth else data.size).joinToString("\n") { "\t-$it" }
        }


    }
}