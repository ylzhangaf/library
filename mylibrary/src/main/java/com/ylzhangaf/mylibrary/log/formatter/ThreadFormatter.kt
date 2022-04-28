package com.ylzhangaf.mylibrary.log.formatter

import com.ylzhangaf.mylibrary.log.LogConfig

class ThreadFormatter : LogFormatter<Thread> {

    override fun format(data: Thread, logConfig: LogConfig): String {
        return data.name
    }

}