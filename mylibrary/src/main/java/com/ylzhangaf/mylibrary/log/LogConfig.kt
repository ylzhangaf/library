package com.ylzhangaf.mylibrary.log

abstract class LogConfig {

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

}