package com.muslim.umra.utils

import android.content.Context
import android.media.MediaPlayer

object Player {
    fun createPlayer(context: Context, resourceId: Int): MediaPlayer {
        return MediaPlayer.create(context, resourceId)
    }
}
