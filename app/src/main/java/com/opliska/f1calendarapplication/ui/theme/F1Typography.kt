package com.opliska.f1calendarapplication.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Typography

data class F1Typography(
    val title1: TextStyle = Title1,
    val customBody1: TextStyle = CustomBody1,
    val defaultTypography: Typography = Typography
)

val Title1 = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp
)

val CustomBody1 = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
)