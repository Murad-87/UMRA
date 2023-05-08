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
fun SafaAndMarvaScreen(
    navController: NavController
) {

    val context = LocalContext.current.applicationContext
    val mediaPlayer1 = Player.createPlayer(context, R.raw.umra_mp3_voice_8)
    val mediaPlayer2 = Player.createPlayer(context, R.raw.umra_mp3_voice_9)
    val mediaPlayer3 = Player.createPlayer(context, R.raw.umra_mp3_voice_10)
    val mediaPlayer4 = Player.createPlayer(context, R.raw.umra_mp3_voice_11)
    val mediaPlayer5 = Player.createPlayer(context, R.raw.umra_mp3_voice_12)
    val isPlaying1 = remember { mutableStateOf(false) }
    val isPlaying2 = remember { mutableStateOf(false) }
    val isPlaying3 = remember { mutableStateOf(false) }
    val isPlaying4 = remember { mutableStateOf(false) }
    val isPlaying5 = remember { mutableStateOf(false) }
    val isRepeatOn1 = remember { mutableStateOf(false) }
    val isRepeatOn2 = remember { mutableStateOf(false) }
    val isRepeatOn3 = remember { mutableStateOf(false) }
    val isRepeatOn4 = remember { mutableStateOf(false) }
    val isRepeatOn5 = remember { mutableStateOf(false) }
    val playbackPosition1 = remember { mutableStateOf(0) }
    val playbackPosition2 = remember { mutableStateOf(0) }
    val playbackPosition3 = remember { mutableStateOf(0) }
    val playbackPosition4 = remember { mutableStateOf(0) }
    val playbackPosition5 = remember { mutableStateOf(0) }
    var maxPlaybackPosition1 by remember { mutableStateOf(0) }
    var maxPlaybackPosition2 by remember { mutableStateOf(0) }
    var maxPlaybackPosition3 by remember { mutableStateOf(0) }
    var maxPlaybackPosition4 by remember { mutableStateOf(0) }
    var maxPlaybackPosition5 by remember { mutableStateOf(0) }
    val progress1 by derivedStateOf { if (maxPlaybackPosition1 != 0) playbackPosition1.value / maxPlaybackPosition1.toFloat() else 0f }
    val progress2 by derivedStateOf { if (maxPlaybackPosition2 != 0) playbackPosition2.value / maxPlaybackPosition2.toFloat() else 0f }
    val progress3 by derivedStateOf { if (maxPlaybackPosition3 != 0) playbackPosition3.value / maxPlaybackPosition3.toFloat() else 0f }
    val progress4 by derivedStateOf { if (maxPlaybackPosition4 != 0) playbackPosition4.value / maxPlaybackPosition4.toFloat() else 0f }
    val progress5 by derivedStateOf { if (maxPlaybackPosition5 != 0) playbackPosition5.value / maxPlaybackPosition5.toFloat() else 0f }

    Scaffold(
        topBar = {
            Navbar(
                title = stringResource(id = R.string.title_safa_and_marva_screen),
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
                text = stringResource(id = R.string.direction_towards_mountain_string),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
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
                    text = "إِنَّ الصَّفَا وَالْمَرْوَةَ مِنْ شَعَائِرِ اللهِ ۖ فَمَنْ حَجَّ الْبَيْتَ أَوِ اعْتَمَرَ فَلَا جُنَاحَ عَلَيْهِ أَنْ يَطَّوَّفَ بِهِمَا ۚ وَمَنْ تَطَوَّعَ خَيْرًا فَإِنَّ اللهَ شَاكِرٌ عَلِيمٌ",
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
                        isPlaying1.value = !isPlaying1.value
                        if (mediaPlayer1.isPlaying) {
                            mediaPlayer1.pause()
                        } else {
                            mediaPlayer1.start()
                        }
                    },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isPlaying1.value) {
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
                    onClick = { isRepeatOn1.value = !isRepeatOn1.value },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isRepeatOn1.value) {
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
                text = formatTime(playbackPosition1.value),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Slider(
                modifier = Modifier
                    .semantics { contentDescription = "Localized Description" }
                    .padding(
                        start = 22.dp, end = 22.dp
                    ),
                value = progress1,
                onValueChange = {
                    playbackPosition1.value = (it * maxPlaybackPosition1).toInt()
                    mediaPlayer1.seekTo(playbackPosition1.value)
                },
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFF26CE08),
                    thumbColor = Color(0xFFFFFFFF),
                ),
            )

            LaunchedEffect(mediaPlayer1) {
                mediaPlayer1.setOnCompletionListener {
                    isPlaying1.value = false
                    playbackPosition1.value = 0
                    if (isRepeatOn1.value) {
                        mediaPlayer1.seekTo(0)
                        mediaPlayer1.start()
                        isPlaying1.value = true
                    }
                }
                while (true) {
                    if (isPlaying1.value) {
                        playbackPosition1.value = mediaPlayer1.currentPosition
                        maxPlaybackPosition1 = mediaPlayer1.duration
                    }
                    delay(16)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.dua_sofa_and_marva_string),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
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
                    text = "نَبْدَأُ بِمَا بَدَأَ اللهُ بِهِ",
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
                        isPlaying2.value = !isPlaying2.value
                        if (mediaPlayer2.isPlaying) {
                            mediaPlayer2.pause()
                        } else {
                            mediaPlayer2.start()
                        }
                    },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isPlaying2.value) {
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
                    onClick = { isRepeatOn2.value = !isRepeatOn2.value },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isRepeatOn2.value) {
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
                text = formatTime(playbackPosition2.value),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Slider(
                modifier = Modifier
                    .semantics { contentDescription = "Localized Description" }
                    .padding(
                        start = 22.dp, end = 22.dp
                    ),
                value = progress2,
                onValueChange = {
                    playbackPosition2.value = (it * maxPlaybackPosition2).toInt()
                    mediaPlayer2.seekTo(playbackPosition2.value)
                },
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFF26CE08),
                    thumbColor = Color(0xFFFFFFFF),
                ),
            )

            LaunchedEffect(mediaPlayer2) {
                mediaPlayer2.setOnCompletionListener {
                    isPlaying2.value = false
                    playbackPosition2.value = 0
                    if (isRepeatOn2.value) {
                        mediaPlayer2.seekTo(0)
                        mediaPlayer2.start()
                        isPlaying2.value = true
                    }
                }
                while (true) {
                    if (isPlaying2.value) {
                        playbackPosition2.value = mediaPlayer2.currentPosition
                        maxPlaybackPosition2 = mediaPlayer2.duration
                    }
                    delay(16)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.dua_when_climbing_mount_safa_string),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp)
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
                    text = "اَلله أَكْبَرُ الله أَكْبَرُ الله اَكْبَرُ، لٰا إِلَهَ إِلَّا اللهُ وَحْدَهُ لٰا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَ لَهُ الْحَمْدُ، يُحْيِي وَ يُمِيتُ ، وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، لَا إِلٰهَ إِلَّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ، أَنْجَزَ وَعْدَهُ، وَنَصَرَ عَبْدَهُ، وَهَزَمَ الْأَحْزَابَ وَحْدَهُ",
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
                        isPlaying3.value = !isPlaying3.value
                        if (mediaPlayer3.isPlaying) {
                            mediaPlayer3.pause()
                        } else {
                            mediaPlayer3.start()
                        }
                    },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isPlaying3.value) {
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
                    onClick = { isRepeatOn3.value = !isRepeatOn3.value },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isRepeatOn3.value) {
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
                text = formatTime(playbackPosition3.value),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Slider(
                modifier = Modifier
                    .semantics { contentDescription = "Localized Description" }
                    .padding(
                        start = 22.dp, end = 22.dp
                    ),
                value = progress3,
                onValueChange = {
                    playbackPosition3.value = (it * maxPlaybackPosition3).toInt()
                    mediaPlayer3.seekTo(playbackPosition3.value)
                },
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFF26CE08),
                    thumbColor = Color(0xFFFFFFFF),
                ),
            )

            LaunchedEffect(mediaPlayer3) {
                mediaPlayer3.setOnCompletionListener {
                    isPlaying3.value = false
                    playbackPosition3.value = 0
                    if (isRepeatOn3.value) {
                        mediaPlayer3.seekTo(0)
                        mediaPlayer3.start()
                        isPlaying3.value = true
                    }
                }
                while (true) {
                    if (isPlaying3.value) {
                        playbackPosition3.value = mediaPlayer3.currentPosition
                        maxPlaybackPosition3 = mediaPlayer3.duration
                    }
                    delay(16)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.dua_on_mount_safa_string),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
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
                    text = "رَبِّ اغْفِرْ وَ ارْحَمْ، إِنَّكَ أَنْتَ الْأَعَزُّ الْاَكْرَم",
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
                        isPlaying4.value = !isPlaying4.value
                        if (mediaPlayer4.isPlaying) {
                            mediaPlayer4.pause()
                        } else {
                            mediaPlayer4.start()
                        }
                    },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isPlaying4.value) {
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
                    onClick = { isRepeatOn4.value = !isRepeatOn4.value },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isRepeatOn4.value) {
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
                text = formatTime(playbackPosition4.value),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Slider(
                modifier = Modifier
                    .semantics { contentDescription = "Localized Description" }
                    .padding(
                        start = 22.dp, end = 22.dp
                    ),
                value = progress4,
                onValueChange = {
                    playbackPosition4.value = (it * maxPlaybackPosition4).toInt()
                    mediaPlayer4.seekTo(playbackPosition4.value)
                },
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFF26CE08),
                    thumbColor = Color(0xFFFFFFFF),
                ),
            )

            LaunchedEffect(mediaPlayer4) {
                mediaPlayer4.setOnCompletionListener {
                    isPlaying4.value = false
                    playbackPosition4.value = 0
                    if (isRepeatOn4.value) {
                        mediaPlayer4.seekTo(0)
                        mediaPlayer4.start()
                        isPlaying4.value = true
                    }
                }
                while (true) {
                    if (isPlaying4.value) {
                        playbackPosition4.value = mediaPlayer4.currentPosition
                        maxPlaybackPosition4 = mediaPlayer4.duration
                    }
                    delay(16)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.permitted_dua_during_passage_of_safa_and_marwa_string),
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
                    text = "اَللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ وَ سَلِّمْ ، اَللَّهُمَّ إِنِّي أَسْأَلُكَ مِنْ فَضْلِكَ",
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
                        isPlaying5.value = !isPlaying5.value
                        if (mediaPlayer5.isPlaying) {
                            mediaPlayer5.pause()
                        } else {
                            mediaPlayer5.start()
                        }
                    },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isPlaying5.value) {
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
                    onClick = { isRepeatOn5.value = !isRepeatOn5.value },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Icon(
                        painter = if (isRepeatOn5.value) {
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
                text = formatTime(playbackPosition5.value),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            Slider(
                modifier = Modifier
                    .semantics { contentDescription = "Localized Description" }
                    .padding(
                        start = 22.dp, end = 22.dp
                    ),
                value = progress5,
                onValueChange = {
                    playbackPosition5.value = (it * maxPlaybackPosition5).toInt()
                    mediaPlayer5.seekTo(playbackPosition5.value)
                },
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFF26CE08),
                    thumbColor = Color(0xFFFFFFFF),
                ),
            )

            LaunchedEffect(mediaPlayer5) {
                mediaPlayer5.setOnCompletionListener {
                    isPlaying5.value = false
                    playbackPosition5.value = 0
                    if (isRepeatOn5.value) {
                        mediaPlayer5.seekTo(0)
                        mediaPlayer5.start()
                        isPlaying5.value = true
                    }
                }
                while (true) {
                    if (isPlaying5.value) {
                        playbackPosition5.value = mediaPlayer5.currentPosition
                        maxPlaybackPosition5 = mediaPlayer5.duration
                    }
                    delay(16)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.dua_at_exit_of_reserved_mosque_string),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }
}