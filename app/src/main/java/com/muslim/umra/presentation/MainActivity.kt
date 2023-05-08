package com.muslim.umra.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.muslim.umra.navigation.MyNavGraph
import com.muslim.umra.utils.Localize
import com.muslim.umra.utils.SharedPreferencesManager
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var sharedPrefsManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPrefsManager = SharedPreferencesManager(this)
        val language = sharedPrefsManager.getSaveAppLanguage()
        Log.d("TEST_ACTIVITY", "App language get: $language")

        if (language.isNotEmpty()) {
            val locale = Locale(language)
            Log.d("TEST_ACTIVITY", "App language get: ${locale.language}")
            Localize.updateLocale(locale)
            Locale.setDefault(locale)
            val resources = this.resources
            val configuration = resources.configuration
            configuration.setLocale(locale)
            resources.updateConfiguration(configuration, resources.displayMetrics)
        }

        setContent {
            val navController = rememberNavController()
            MyNavGraph(navController = navController)
            MainScreen()
        }
    }
}
