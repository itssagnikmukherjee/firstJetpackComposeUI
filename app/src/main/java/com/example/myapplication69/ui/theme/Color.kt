package com.example.myapplication69.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val MyBlack = Color(0xFF1D1D1D)
val MyGreen = Color(0xFF20CF20)
val MyGrey = Color(0xFF3A3A3A)

// the color pallet colors

val deepBlue = Color(0xFF3F51B5)
val forestGreen = Color(0xFF388E3C)
val darkGrey = Color(0xFF535353)
val lightGrey = Color(0xFFFAFAFF)
val sunsetOrange = Color(0xFFC77B63)
val royalPurple = Color(0xFF673AB7)
val myYellow = Color(0xFFFFEB3B)
val myRed = Color(0xFFDD4A56)

val backgroundGradient = Brush.verticalGradient(
    listOf(
        Color(0xFF232020),
        Color(0xFF1F1F1E),
        Color(0xFF232020),
    ),
)

val purpleGradient = Brush.verticalGradient(
    listOf(
        royalPurple,
        deepBlue
    ),45f

)

val orangeGradient = Brush.verticalGradient(
    listOf(
        myRed,
        sunsetOrange
    ),45f
)