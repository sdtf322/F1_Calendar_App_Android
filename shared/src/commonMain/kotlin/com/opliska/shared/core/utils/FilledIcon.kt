package com.opliska.shared.core.presentation.utils

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab


//Todo Implement util function when icons will be added to a project
@Composable
fun FilledIcon(item: Tab) = when (item.options.index) {
    (0u).toUShort() -> null
    (1u).toUShort() -> null
    (2u).toUShort() -> null
    else -> null
}