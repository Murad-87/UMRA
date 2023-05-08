package com.muslim.umra.uikit

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun AppSlider(
    modifier: Modifier = Modifier,
    value: Float,
    onValueChange: (Float) -> Unit,
    activeTrackColor: Color = Color(0xFF26CE08),
    thumbColor: Color = Color(0xFFFFFFFF),
) {
    Slider(
        modifier = modifier
            .semantics { contentDescription = "Localized Description"  }
            .padding(start = 26.dp, end = 26.dp),
        value = value,
        onValueChange = {onValueChange},
        colors = SliderDefaults.colors(
            activeTrackColor = activeTrackColor,
            thumbColor = thumbColor,
        ),
    )
}