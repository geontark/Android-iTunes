package com.devtak.watcha.presentation.ui.activity

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun showToast(@StringRes strResId: Int, isLong: Boolean) {
        val timeType = if(isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
        Toast.makeText(
            this@BaseActivity,
            strResId,
            timeType
        ).show()
    }
}