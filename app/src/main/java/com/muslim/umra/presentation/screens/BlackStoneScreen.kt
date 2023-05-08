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
fun BlackStoneScreen(
    navController: NavController
) {

    val context = LocalContext.current.applicationContext
    val mediaPlayer = Player.createPlayer(context, R.raw.umra_mp3_voice_6)
    val isPlaying = remember { mutableStateOf(false) }
    val isRepeatOn = remember { mutableStateOf(false) }
    val playbackPosition = remember { mutableStateOf(0) }
    var maxPlaybackPosition by remember { mutableStateOf(0) }
    val progress by derivedStateOf { if (maxPlaybackPosition != 0) playbackPosition.value / maxPlaybackPosition.toFloat() else 0f }

    Scaffold(
        topBar = {
            Navbar(
                title = stringResource(id = R.string.title_black_stone_screen),
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
                text = stringResource(id = R.string.return_to_the_black_stone_string),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = R.string.allah_is_great_string),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(30.dp))

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
                    text = stringResource(id = R.string.Allah_is_great_string),
                    fontSize = 30.sp,
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
                        if (mediaPlayer.isPlaying) {
                            mediaPlayer.pause()
                        } else {
                            mediaPlayer.start()
                        }
                        isPlaying.value = !isPlaying.value
                    },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isPlaying.value) {
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
                    mediaPlayer.seekTo(playbackPosition.value)
                },
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFF26CE08),
                    thumbColor = Color(0xFFFFFFFF),
                ),
            )

            LaunchedEffect(mediaPlayer) {
                mediaPlayer.setOnCompletionListener {
                    isPlaying.value = false
                    playbackPosition.value = 0
                    if (isRepeatOn.value) {
                        mediaPlayer.seekTo(0)
                        mediaPlayer.start()
                        isPlaying.value = true
                    }
                }
                while (true) {
                    if (isPlaying.value) {
                        playbackPosition.value = mediaPlayer.currentPosition
                        maxPlaybackPosition = mediaPlayer.duration
                    }
                    delay(16)
                }
            }
        }
    }
}
