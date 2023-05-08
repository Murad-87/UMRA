package com.muslim.umra.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.muslim.umra.presentation.screens.*
import com.muslim.umra.utils.ConstantsNavigation

@Composable
fun MyNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = ConstantsNavigation.UMRA_SCREEN) {

        composable(route = ConstantsNavigation.UMRA_SCREEN) {
            UmraMainScreen(navController)
        }

        composable(route = ConstantsNavigation.IHRAM_SCREEN) {
            IhramScreen(navController)
        }

        composable(route = ConstantsNavigation.ROUND_KAABA_SCREEN) {
            RoundKaabaScreen(navController)
        }

        composable(route = ConstantsNavigation.PLACE_IBROHIM_SCREEN) {
            PlaceIbrohimScreen(navController)
        }

        composable(route = ConstantsNavigation.WATER_ZAMZAM_SCREEN) {
            WaterZamzamScreen(navController)
        }

        composable(route = ConstantsNavigation.BLACK_STONE_SCREEN) {
            BlackStoneScreen(navController)
        }

        composable(route = ConstantsNavigation.SAFA_MARVA_SCREEN) {
            SafaAndMarvaScreen(navController)
        }

        composable(route = ConstantsNavigation.SHAVE_HEAD_SCREEN) {
            ShaveHeadScreen(navController)
        }

        composable(route = ConstantsNavigation.LINK_BOOK_SCREEN) {
            LinkBookScreen()
        }

        composable(route = ConstantsNavigation.SETTINGS_SCREEN) {
            SettingsScreen(navController)
        }
    }
}