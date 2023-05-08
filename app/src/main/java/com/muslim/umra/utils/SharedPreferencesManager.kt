package com.muslim.umra.utils

import android.content.Context
import android.content.SharedPreferences
import java.util.*

class SharedPreferencesManager(context: Context) {

    companion object {
        private const val SHARED_PREFS_NAME = "MyAppPreferences"
        private const val KEY_APP_LANGUAGE = "AppLanguage"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        SHARED_PREFS_NAME,
        Context.MODE_PRIVATE
    )

    var appLanguage: String
        get() = sharedPreferences.getString(KEY_APP_LANGUAGE, "") ?: ""
        set(value) = sharedPreferences.edit().putString(KEY_APP_LANGUAGE, value).apply()

    fun saveAppLanguage(language: String) {
        appLanguage = language
    }

    fun getSaveAppLanguage(): String {
        return sharedPreferences.getString(KEY_APP_LANGUAGE, Locale.getDefault().language) ?: Locale.getDefault().language
    }
}