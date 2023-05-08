package com.muslim.umra.utils

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf
import java.util.*

object Localize {

    @SuppressLint("ConstantLocale")
    private val locale = mutableStateOf(Locale.getDefault())

    fun currentLocale(): Locale = locale.value

    fun updateLocale(locale: Locale) {
        this.locale.value = locale
    }
}