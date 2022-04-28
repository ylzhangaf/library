package com.ylzhangaf.mylibrary.log.printer

import android.util.Log
import com.ylzhangaf.mylibrary.log.LogConfig
import com.ylzhangaf.mylibrary.log.LogConfig.Companion.MAX_LEN

class ConsolePrinter : LogPrinter {
    override fun print(logConfig: LogConfig, level: Int, tag: String, printString: String) {
        val printLenght = printString.length
        val countOfSubStr = printLenght / MAX_LEN
        if (countOfSubStr > 0) {
            var strIndex = 0
            for (index in 0 until countOfSubStr) {
                Log.println(level, tag, printString.substring(strIndex, strIndex + MAX_LEN))
                strIndex += MAX_LEN
            }

            if (strIndex != printLenght) {
                Log.println(level, tag, printString.substring(strIndex, printLenght))
            }
        } else {
            Log.println(level, tag, printString)
        }
    }
}