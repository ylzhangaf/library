package com.ylzhangaf.mylibrary.log.formatter

import com.ylzhangaf.mylibrary.log.LogConfig

interface LogFormatter<T> {
    fun format(data : T, logConfig: LogConfig) : String
}