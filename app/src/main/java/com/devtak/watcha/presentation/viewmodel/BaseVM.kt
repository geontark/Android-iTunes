package com.devtak.watcha.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devtak.watcha.core.wrapper.Event
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseVM : ViewModel() {
    private val _isLoading = MutableLiveData<Event<Boolean>>()
    val isLoading: LiveData<Event<Boolean>> = _isLoading

    private val _toastEvent = MutableLiveData<Event<Int>>()
    val toastEvent: LiveData<Event<Int>> = _toastEvent

    private val compositeDisposable = CompositeDisposable()

    fun loading(isLoading: Boolean) {
        _isLoading.value = Event(isLoading)
    }

    fun showToast(resId: Int) {
        _toastEvent.value = Event(resId)
    }

    fun clearCompositeDisposable() {
        compositeDisposable.clear()
    }

    fun addDisposable(dispose: Disposable) {
        compositeDisposable.add(dispose)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}