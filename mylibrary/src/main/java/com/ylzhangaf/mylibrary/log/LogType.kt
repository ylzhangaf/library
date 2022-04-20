package com.ylzhangaf.mylibrary.log

import android.util.Log
import androidx.annotation.IntDef

/**
 * 日志类型
 */
object LogType {

    @IntDef(V,E,I,D)
    @Retention(AnnotationRetention.SOURCE)
    annotation class TYPE

    const val V = Log.VERBOSE
    const val E = Log.ERROR
    const val I = Log.INFO
    const val D = Log.DEBUG
}