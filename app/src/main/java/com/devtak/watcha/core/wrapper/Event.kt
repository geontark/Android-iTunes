package com.devtak.watcha.core.wrapper

import androidx.lifecycle.Observer

/**
 * 이벤트를 나타내는 LiveData를 통해 전송되는 데이터의 wrapper
 */
class Event<out T>(private val content: T) {
    var hasBeenHandled = false
        private set // 외부에서 읽기만 가능, 수정은 내부에서만 가능

    // 읽지 않은 데이터만 다룸
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}