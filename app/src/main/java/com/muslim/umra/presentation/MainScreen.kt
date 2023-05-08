package com.muslim.umra.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.muslim.umra.R
import com.muslim.umra.navigation.MyNavGraph
import com.muslim.umra.uikit.Navbar
import com.muslim.umra.utils.ConstantsNavigation

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var showTopAppBar by rememberSaveable { mutableStateOf(false) }

    showTopAppBar = when (navBackStackEntry?.destination?.route) {
        ConstantsNavigation.UMRA_SCREEN -> true
        else -> false
    }

    Scaffold(
        topBar = {
            if (showTopAppBar) {
                Navbar(
                    title = stringResource(id = R.string.main_screen_name_string),
                    shouldShowStartIcon = false,
                    endIcon = painterResource(id = R.drawable.ic_settings),
                    endIconAction = {
                        navController.navigate(route = ConstantsNavigation.SETTINGS_SCREEN)
                    },
                    endIconColorTint = colorResource(id = R.color.icon_color_topbar)
                )
            }
        },
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ) {
            MyNavGraph(navController = navController)
        }
    }
}