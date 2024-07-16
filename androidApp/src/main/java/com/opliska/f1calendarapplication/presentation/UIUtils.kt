package com.opliska.f1calendarapplication.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.opliska.f1calendarapplication.R

@Composable
fun getFlagImageByCountry(country: String): ImageVector {
    val drawableRes = when (country.lowercase()) {
        "bahrain" -> R.drawable.bahrain_flag
        "saudi arabia" -> R.drawable.saudi_arabia_flag
        "australia" -> R.drawable.australia_flag
        "japan" -> R.drawable.japan_flag
        "china" -> R.drawable.china_flag
        "usa" -> R.drawable.united_states_of_america_flag
        "italy" -> R.drawable.italy_flag
        "monaco" -> R.drawable.monaco_flag
        "canada" -> R.drawable.canada_flag
        "spain" -> R.drawable.spain_flag
        "austria" -> R.drawable.austria_flag
        "uk" -> R.drawable.united_kingdom_flag
        "hungary" -> R.drawable.hungary_flag
        "belgium" -> R.drawable.belgium_flag
        "netherlands" -> R.drawable.netherlands_flag
        "azerbaijan" -> R.drawable.azerbaijan_flag
        "singapore" -> R.drawable.singapore_flag
        "mexico" -> R.drawable.mexico_flag
        "brazil" -> R.drawable.brazil_flag
        "qater" -> R.drawable.qatar_flag
        "uae" -> R.drawable.united_arab_emirates_flag
        else -> R.drawable.saudi_arabia_flag
    }
    return ImageVector.vectorResource(id = drawableRes)
}