package com.devtak.watcha.core.log

import android.util.Log

/**
 * 로그 커스텀
 */
object Logg {
    private const val isShow = true

    private fun tag(): String? {
        return Thread.currentThread().stackTrace[4].let {
            val link = "(${it.fileName}:${it.lineNumber})"
            val path = "App# ${it.className.substringAfterLast(".")}.${it.methodName}"
            if (path.length + link.length > 80) {
                "${path.take(80 - link.length)}...${link}"
            } else {
                "${path}${link}"
            }
        }
    }
    fun v(msg: String?) {
        if(isShow) Log.v(tag(), "" + msg)
    }
    fun d(msg: String?) {
        if(isShow) Log.d(tag(), "" + msg)
    }
    fun i(msg: String?) {
        if(isShow) Log.i(tag(), "" + msg)
    }
    fun w(msg: String?) {
        if(isShow) Log.w(tag(), "" + msg)
    }
    fun w(e: Throwable?) {
        if(isShow) Log.w(tag(), "" + e?.localizedMessage)
    }
    fun w(e: Exception?) {
        if(isShow) Log.w(tag(), "" + e?.localizedMessage)
    }
    fun e(msg: String?) {
        if(isShow) Log.e(tag(), "" + msg)
    }
}