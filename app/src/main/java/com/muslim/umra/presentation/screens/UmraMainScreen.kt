package com.muslim.umra.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.muslim.umra.R
import com.muslim.umra.utils.ConstantsNavigation

@Composable
fun UmraMainScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 18.dp, horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 15.dp)
                .clickable {
                    navController.navigate(route = ConstantsNavigation.IHRAM_SCREEN) {
                        popUpTo(route = ConstantsNavigation.UMRA_SCREEN) { inclusive = false }
                    }
                },
            elevation = 12.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_1),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.title_ihram_screen),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF884430),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))

        Divider(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 15.dp)
                .clickable {
                    navController.navigate(route = ConstantsNavigation.ROUND_KAABA_SCREEN) {
                        popUpTo(route = ConstantsNavigation.UMRA_SCREEN) { inclusive = false }
                    }
                },
            elevation = 12.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_2_tawaf),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.title_round_kaaba_screen),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF884430),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))

        Divider(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 15.dp)
                .clickable {
                    navController.navigate(route = ConstantsNavigation.PLACE_IBROHIM_SCREEN) {
                        popUpTo(route = ConstantsNavigation.UMRA_SCREEN) { inclusive = false }
                    }
                },
            elevation = 12.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_3),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.title_place_ibrohim_stand_screen),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF884430),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))

        Divider(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 15.dp)
                .clickable {
                    navController.navigate(route = ConstantsNavigation.WATER_ZAMZAM_SCREEN) {
                        popUpTo(route = ConstantsNavigation.UMRA_SCREEN) { inclusive = false }
                    }
                },
            elevation = 12.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_4_zam_zam),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.title_water_zamzam_screen),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF884430),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))

        Divider(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 15.dp)
                .clickable {
                    navController.navigate(route = ConstantsNavigation.BLACK_STONE_SCREEN) {
                        popUpTo(route = ConstantsNavigation.UMRA_SCREEN) { inclusive = false }
                    }
                },
            elevation = 12.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_5),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.title_black_stone_screen),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF884430),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))

        Divider(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 15.dp)
                .clickable {
                    navController.navigate(route = ConstantsNavigation.SAFA_MARVA_SCREEN) {
                        popUpTo(route = ConstantsNavigation.UMRA_SCREEN) { inclusive = false }
                    }
                },
            elevation = 12.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_6),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.title_safa_and_marva_screen),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF884430),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))

        Divider(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 15.dp)
                .clickable {
                    navController.navigate(route = ConstantsNavigation.SHAVE_HEAD_SCREEN) {
                        popUpTo(route = ConstantsNavigation.UMRA_SCREEN) { inclusive = false }
                    }
                },
            elevation = 12.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_7),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.title_shave_head_screen),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF884430),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))

        Divider(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 15.dp)
                .clickable {
                    navController.navigate(route = ConstantsNavigation.LINK_BOOK_SCREEN) {
                        popUpTo(route = ConstantsNavigation.UMRA_SCREEN) { inclusive = false }
                    }
                },
            elevation = 12.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_9),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.title_link_book_screen),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF884430),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))

        Divider(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(8.dp))
    }
}