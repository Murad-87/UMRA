package com.muslim.umra.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muslim.umra.R

@Composable
fun LinkBookScreen() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_book),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)

        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.book_will_be_added_soon_string),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic
        )
    }
}