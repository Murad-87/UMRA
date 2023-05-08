package com.muslim.umra.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.muslim.umra.R
import com.muslim.umra.uikit.Navbar

@Composable
fun WaterZamzamScreen(
    navController: NavController
) {

    Scaffold(
        topBar = {
            Navbar(
                title = stringResource(id = R.string.title_water_zamzam_screen),
                backgroundColor = Color(0xFFfaeddd),
                navController = navController
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = Color(0xFFfaeddd))
                .padding(innerPadding)
                .padding(vertical = 10.dp, horizontal = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.water_zam_zam_string),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}