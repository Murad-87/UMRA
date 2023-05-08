package com.muslim.umra.uikit

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.muslim.umra.utils.ConstantsNavigation

@Composable
fun Navbar(
    title: String,
    titleSize: TextUnit = TextUnit.Unspecified,
    titleColor: Color = Color.Black,
    navController: NavController? = null,
    endIcon: Painter? = null,
    shouldShowStartIcon: Boolean = true,
    endIconAction: (() -> Unit)? = null,
    elevation: Dp = 0.dp,
    backgroundColor: Color = Color.White,
    endIconColorTint: Color = Color.Black
) {
    TopAppBar(
        title = {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                if (shouldShowStartIcon) {
                    IconButton(
                        onClick = {
                            navController?.navigate(ConstantsNavigation.UMRA_SCREEN) {
                                popUpTo(route = ConstantsNavigation.UMRA_SCREEN) {
                                    inclusive = true
                                }
                            }
                        },
                        modifier = Modifier.align(Alignment.CenterStart)
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
                if (endIcon != null) {
                    IconButton(
                        onClick = { endIconAction?.invoke() },
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        Icon(
                            painter = endIcon,
                            contentDescription = null,
                            tint = endIconColorTint
                        )
                    }
                }
                Text(
                    text = title,
                    fontSize = 22.sp,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            }
        },
        backgroundColor = backgroundColor,
        elevation = elevation
    )
}