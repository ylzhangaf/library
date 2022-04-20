package com.ylzhangaf.mylibrary.log

class LogManager private constructor(private val logConfig: LogConfig) {

    companion object {

        private lateinit var logManagerInstance : LogManager

        fun getInstance() : LogManager {
            return logManagerInstance
        }

        fun init(logConfig: LogConfig) {
            logManagerInstance = LogManager(logConfig)
        }

    }

    fun getConfig() : LogConfig {
        return logConfig
    }

}