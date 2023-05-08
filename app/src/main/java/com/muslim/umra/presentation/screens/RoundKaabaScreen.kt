package com.muslim.umra.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.muslim.umra.R
import com.muslim.umra.uikit.Navbar
import com.muslim.umra.utils.Player
import com.muslim.umra.utils.formatTime
import kotlinx.coroutines.delay

@SuppressLint("UnrememberedMutableState")
@Composable
fun RoundKaabaScreen(
    navController: NavController
) {

    val context = LocalContext.current.applicationContext
    val voice6 = Player.createPlayer(context, R.raw.umra_mp3_voice_6)
    val voice7 = Player.createPlayer(context, R.raw.umra_mp3_voice_7)
    val isPlaying6 = remember { mutableStateOf(false) }
    val isPlaying7 = remember { mutableStateOf(false) }
    val isRepeatOn = remember { mutableStateOf(false) }
    val isRepeatOn7 = remember { mutableStateOf(false) }
    val playbackPosition7 = remember { mutableStateOf(0) }
    val playbackPosition = remember { mutableStateOf(0) }
    var maxPlaybackPosition by remember { mutableStateOf(0) }
    var maxPlaybackPosition7 by remember { mutableStateOf(0) }
    val progress by derivedStateOf { if (maxPlaybackPosition != 0) playbackPosition.value / maxPlaybackPosition.toFloat() else 0f }
    val progress7 by derivedStateOf { if (maxPlaybackPosition7 != 0) playbackPosition7.value / maxPlaybackPosition7.toFloat() else 0f }

    Scaffold(
        topBar = {
            Navbar(
                title = stringResource(id = R.string.title_round_kaaba_screen),
                backgroundColor = Color(0xFFfaeddd),
                navController = navController
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFfaeddd))
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(vertical = 10.dp, horizontal = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.beginning_of_seven_fold_crawl_string),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFF1DA515), Color(0xFF899392)),
                            startY = 0.7f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    ),
                contentAlignment = Alignment.Center,

                ) {
                Text(
                    text = "الله أكبر",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.wrapContentHeight()
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = {
                        isPlaying6.value = !isPlaying6.value
                        if (voice6.isPlaying) {
                            voice6.pause()
                        } else {
                            voice6.start()
                        }
                    },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isPlaying6.value) {
                            painterResource(id = R.drawable.ic_pause)
                        } else {
                            painterResource(id = R.drawable.ic_play)
                        },
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        tint = Color(0xFF1DA515)
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                IconButton(
                    onClick = { isRepeatOn.value = !isRepeatOn.value },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isRepeatOn.value) {
                            painterResource(id = R.drawable.ic_repeat_start)
                        } else {
                            painterResource(id = R.drawable.ic_replay)
                        },
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        tint = Color(0xFFDB1229)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = formatTime(playbackPosition.value),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Slider(
                modifier = Modifier
                    .semantics { contentDescription = "Localized Description" }
                    .padding(
                        start = 22.dp, end = 22.dp
                    ),
                value = progress,
                onValueChange = {
                    playbackPosition.value = (it * maxPlaybackPosition).toInt()
                    voice6.seekTo(playbackPosition.value)
                },
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFF26CE08),
                    thumbColor = Color(0xFFFFFFFF),
                ),
            )

            LaunchedEffect(voice6) {
                voice6.setOnCompletionListener {
                    isPlaying6.value = false
                    playbackPosition.value = 0
                    if (isRepeatOn.value) {
                        voice6.seekTo(0)
                        voice6.start()
                        isPlaying6.value = true
                    }
                }
                while (true) {
                    if (isPlaying6.value) {
                        playbackPosition.value = voice6.currentPosition
                        maxPlaybackPosition = voice6.duration
                    }
                    delay(16)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.beginning_of_crawl_from_black_stone_string),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFF1DA515), Color(0xFF899392)),
                            startY = 0.7f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    ),
                contentAlignment = Alignment.Center,

                ) {
                Text(
                    text = " رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً وَفِي الْآخِرَةِ حَسَنَةً وَقِنَا عَذَابَ النَّارِ",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.wrapContentHeight()
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = {
                        isPlaying7.value = !isPlaying7.value
                        if (voice7.isPlaying) {
                            voice7.pause()
                        } else {
                            voice7.start()
                        }
                    },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isPlaying7.value) {
                            painterResource(id = R.drawable.ic_pause)
                        } else {
                            painterResource(id = R.drawable.ic_play)
                        },
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        tint = Color(0xFF1DA515)
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                IconButton(
                    onClick = {isRepeatOn7.value = !isRepeatOn7.value },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isRepeatOn7.value) {
                            painterResource(id = R.drawable.ic_repeat_start)
                        } else {
                            painterResource(id = R.drawable.ic_replay)
                        },
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        tint = Color(0xFFDB1229)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = formatTime(playbackPosition7.value),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Slider(
                modifier = Modifier
                    .semantics { contentDescription = "Localized Description" }
                    .padding(
                        start = 22.dp, end = 22.dp
                    ),
                value = progress7,
                onValueChange = {
                    playbackPosition7.value = (it * maxPlaybackPosition7).toInt()
                    voice7.seekTo(playbackPosition7.value)
                },
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFF26CE08),
                    thumbColor = Color(0xFFFFFFFF),
                ),
            )

            LaunchedEffect(voice7) {
                voice7.setOnCompletionListener {
                    isPlaying7.value = false
                    playbackPosition7.value = 0
                    if (isRepeatOn7.value) {
                        voice7.seekTo(0)
                        voice7.start()
                        isPlaying7.value = true
                    }
                }
                while (true) {
                    if (isPlaying7.value) {
                        playbackPosition7.value = voice7.currentPosition
                        maxPlaybackPosition7 = voice7.duration
                    }
                    delay(16)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.dua_to_the_lord_string),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }
}