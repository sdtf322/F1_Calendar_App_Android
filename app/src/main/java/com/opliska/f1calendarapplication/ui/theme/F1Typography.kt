package com.opliska.f1calendarapplication.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.opliska.f1calendarapplication.R

data class F1Typography(
    val title1: TextStyle = Title1,
    val customBody1: TextStyle = CustomBody1,
    val defaultTypography: Typography = Typography
)

val SplineSans = FontFamily(
    Font(R.font.spline_sans_light, FontWeight.Light),
    Font(R.font.spline_sans_regular, FontWeight.Normal),
    Font(R.font.spline_sans_medium, FontWeight.Medium),
    Font(R.font.spline_sans_semi_bold, FontWeight.SemiBold),
    Font(R.font.spline_sans_bold, FontWeight.Bold)
)

val Title1 = TextStyle(
    fontFamily = SplineSans,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp
)

val CustomBody1 = TextStyle(
    fontFamily = SplineSans,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
)