package com.devtak.watcha.presentation.ui.activity

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.devtak.watcha.core.log.Logg
import com.devtak.watcha.presentation.viewmodel.BaseVM

abstract class BaseActivity : AppCompatActivity() {

    fun initBaseVM(vararg baseVMs: BaseVM) {
        for(baseVM in baseVMs) {
            initObserveEvent(baseVM = baseVM)
        }
    }

    private fun initObserveEvent(baseVM: BaseVM) {
        baseVM.toastEvent.observe(this, {
            it.getContentIfNotHandled()?.let { strResId ->
                showToast(strResId = strResId, false)
            }
        })
    }

    private fun showToast(@StringRes strResId: Int, isLong: Boolean) {
        val timeType = if(isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
        Toast.makeText(
            this@BaseActivity,
            strResId,
            timeType
        ).show()
    }
}