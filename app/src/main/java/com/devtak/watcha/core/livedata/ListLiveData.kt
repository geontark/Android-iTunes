package com.devtak.watcha.core.livedata

import androidx.lifecycle.MutableLiveData

/**
 * 리스트라이브데이터 자동갱신 호출을 위한 커스텀 클래스
 */
class ListLiveData<T> : MutableLiveData<ArrayList<T>>() {
    init {
        value = ArrayList()
    }

    fun isExist(item: T): Boolean {
        val items: ArrayList<T> = value ?: ArrayList<T>()
        return items.indexOf(item) != -1
    }

    fun preAdd(item: T) {
        val items: ArrayList<T> = value ?: ArrayList<T>()
        val list = arrayListOf<T>(item)
        list.addAll(items)
        value = list
    }

    fun add(item: T) {
        val items: ArrayList<T> = value ?: ArrayList<T>()
        items.add(item)
        value = items
    }

    fun add(list: List<T>) {
        val items: ArrayList<T> = value ?: ArrayList<T>()
        items.addAll(list)
        value = items
    }

    fun addAll(list: List<T>) {
        val items: ArrayList<T>? = value
        items?.addAll(list)
        value = items
    }

    fun replace(list: List<T>) {
        val items = ArrayList<T>()
        items.addAll(list)
        value = items
    }

    fun replace(position: Int, item: T) {
        val items: ArrayList<T> = value ?: ArrayList<T>()
        if(position > -1 && position < items.size) {
            val newList = ArrayList<T>()
            newList.addAll(items)
            newList[position] = item
            value = newList
        }
    }

    // 기존의 데이터 지우고 새로운데이터로 변경
    fun clearAdd(list: List<T>) {
        clear(false)
        add(list)
    }

    fun clear(notify: Boolean) {
        val items: ArrayList<T> = value ?: ArrayList<T>()
        items.clear()
        if(notify)
            value = items
    }

    fun remove(item: T): Boolean {
        val items: ArrayList<T> = value ?: ArrayList<T>()
        val result = items.remove(item)
        value = items
        return result
    }

    fun notifyChange() {
        val items: ArrayList<T> = value ?: ArrayList<T>()
        value = items
    }
}