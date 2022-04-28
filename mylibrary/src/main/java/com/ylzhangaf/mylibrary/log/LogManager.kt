package com.ylzhangaf.mylibrary.log

import com.ylzhangaf.mylibrary.log.printer.LogPrinter

class LogManager private constructor(private val logConfig: LogConfig, private val logPrinters : MutableList<LogPrinter>) {

    companion object {

        private lateinit var logManagerInstance : LogManager

        fun getInstance() : LogManager {
            return logManagerInstance
        }

        fun init(logConfig: LogConfig, logPrinters: List<LogPrinter>?) {
            logManagerInstance = LogManager(logConfig,logPrinters?.toMutableList() ?: mutableListOf())
        }

    }

    fun getConfig() : LogConfig {
        return logConfig
    }

    fun addPrinter(printer: LogPrinter) {
        logPrinters.add(printer)
    }

    fun removePrinter(printer: LogPrinter) {
        logPrinters.remove(printer)
    }

    fun getPrinters() : List<LogPrinter> {
        return logPrinters
    }

}