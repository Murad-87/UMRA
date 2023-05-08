package com.muslim.umra.utils

fun formatTime(timeInMillis: Int): String {
    val minutes = (timeInMillis / 1000 / 60).toString().padStart(2, '0')
    val seconds = (timeInMillis / 1000) % 60
    return "$minutes:${String.format("%02d", seconds)}"
}