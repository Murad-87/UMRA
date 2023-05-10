package com.muslim.umra.uikit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.muslim.umra.R
import com.muslim.umra.utils.ConstantsNavigation
import com.muslim.umra.utils.Localize
import com.muslim.umra.utils.SharedPreferencesManager
import java.util.*

@Composable
fun MyBottomSheet(
    navController: NavController,
    sharedPrefsManager: SharedPreferencesManager
) {

    val context = LocalContext.current
    var isVisibleRu by remember { mutableStateOf(false) }
    var isVisibleGer by remember { mutableStateOf(false) }
    var currentLocale = Locale.getDefault()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(top = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(id = R.string.select_language_string),
            fontSize = 18.sp
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .clickable {
                    if (currentLocale != Locale("ru")) {
                        currentLocale = Locale("ru")
                    }
                    Localize.updateLocale(currentLocale)
                    Locale.setDefault(currentLocale)
                    val resources = context.resources
                    val configuration = resources.configuration
                    configuration.setLocale(currentLocale)
                    resources.updateConfiguration(configuration, resources.displayMetrics)
                    sharedPrefsManager.saveAppLanguage(currentLocale.language)
                    navController.navigate(ConstantsNavigation.UMRA_SCREEN) {
                        popUpTo(route = ConstantsNavigation.UMRA_SCREEN) { inclusive = true }
                    }
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.russian_string),
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
            if (isVisibleRu) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_check_language),
                    contentDescription = null,
                    tint = Color(0xFF118F17),
                    modifier = Modifier.padding(end = 20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .clickable {
                    if (currentLocale != Locale("de")) {
                        currentLocale = Locale("de")
                    }
                    Localize.updateLocale(currentLocale)
                    Locale.setDefault(currentLocale)
                    val resources = context.resources
                    val configuration = resources.configuration
                    configuration.setLocale(currentLocale)
                    resources.updateConfiguration(configuration, resources.displayMetrics)
                    sharedPrefsManager.saveAppLanguage(currentLocale.language)
                    navController.navigate(ConstantsNavigation.UMRA_SCREEN) {
                        popUpTo(route = ConstantsNavigation.UMRA_SCREEN) { inclusive = true }
                    }
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.deutsche_string),
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
            if (isVisibleGer) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_check_language),
                    contentDescription = null,
                    tint = Color(0xFF118F17),
                    modifier = Modifier.padding(end = 20.dp)
                )
            }
        }
    }
    when (currentLocale) {
        Locale("ru") -> {
            isVisibleRu = true
        }
        Locale("de") -> {
            isVisibleGer = true
        }
        else -> {
            Locale.getDefault()
        }
    }
}