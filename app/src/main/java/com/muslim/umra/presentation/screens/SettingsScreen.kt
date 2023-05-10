package com.muslim.umra.presentation.screens

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.muslim.umra.R
import com.muslim.umra.uikit.MyBottomSheet
import com.muslim.umra.uikit.Navbar
import com.muslim.umra.utils.SharedPreferencesManager
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsScreen(
    navController: NavController
) {

    val context = LocalContext.current.applicationContext
    val sharedPrefsManager = SharedPreferencesManager(context)
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()
    val mailIntent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:commentmyapp@gmail.com")
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }

    Scaffold(
        topBar = {
            Navbar(
                title = stringResource(id = R.string.title_settings_screen),
                navController = navController,
                backgroundColor = Color(0xFFf2f1f7)
            )
        }
    ) { innerPadding ->

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {
                MyBottomSheet(navController, sharedPrefsManager)
            },
            sheetPeekHeight = 0.dp,
            sheetShape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp),
            sheetElevation = 10.dp
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(color = Color(0xFFf2f1f7))
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 10.dp, horizontal = 14.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = stringResource(id = R.string.feedback_settings_screen_string),
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .height(90.dp)
                        .background(Color.White),
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp)
                    ) {

                        Spacer(modifier = Modifier.height(10.dp))

                        Icon(
                            modifier = Modifier.padding(start = 4.dp),
                            painter = painterResource(id = R.drawable.ic_mail_settings),
                            contentDescription = null,
                            tint = Color(0xFF0267B9)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 4.dp)
                        )

                        TextButton(onClick = {
                            context.startActivity(mailIntent)
                        }) {
                            Text(
                                text = stringResource(id = R.string.text_button_feedback_string),
                                color = Color(0xFF0267B9)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.evaluate_the_app_string),
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .height(90.dp)
                        .background(Color.White)
                ) {

                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp)
                    ) {

                        Spacer(modifier = Modifier.height(10.dp))

                        Icon(
                            modifier = Modifier.padding(start = 4.dp),
                            painter = painterResource(id = R.drawable.ic_star_settings),
                            contentDescription = null,
                            tint = Color(0xFFFDC90A)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 4.dp)
                        )

                        TextButton(onClick = { /*TODO*/ }) {
                            Text(
                                text = stringResource(id = R.string.text_button_rate_the_app_string),
                                color = Color(0xFF0267B9)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.support_the_developer_string),
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .height(90.dp)
                        .background(Color.White)
                ) {

                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp)
                    ) {

                        Spacer(modifier = Modifier.height(10.dp))

                        Icon(
                            modifier = Modifier.padding(start = 4.dp),
                            painter = painterResource(id = R.drawable.ic_support_settings),
                            contentDescription = null,
                            tint = Color(0xFFE62727)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 4.dp)
                        )

                        TextButton(onClick = {
                            Toast.makeText(context, "Функция не добавлена", Toast.LENGTH_SHORT).show()
                        }) {
                            Text(
                                text = stringResource(id = R.string.text_button_support_string),
                                color = Color(0xFF0267B9)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "LANGUAGE SELECTION",
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .height(90.dp)
                        .background(Color.White)
                ) {

                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp)
                    ) {

                        Spacer(modifier = Modifier.height(10.dp))

                        Icon(
                            modifier = Modifier.padding(start = 4.dp),
                            painter = painterResource(id = R.drawable.ic_language),
                            contentDescription = null,
                            tint = Color(0xFF118F17)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 4.dp)
                        )

                        TextButton(onClick = {
                            scope.launch {
                                sheetState.expand()
                            }
                        }) {
                            Text(
                                text = stringResource(id = R.string.select_language_settings_string),
                                color = Color(0xFF0267B9)
                            )
                        }
                    }
                }
            }
        }
    }
}


