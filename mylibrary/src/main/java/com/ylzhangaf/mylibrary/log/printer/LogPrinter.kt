package com.ylzhangaf.mylibrary.log.printer

import com.ylzhangaf.mylibrary.log.LogConfig

interface LogPrinter {
    fun print(logConfig: LogConfig, level : Int, tag : String, printString : String)
}