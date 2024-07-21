package com.opliska.shared.core.presentation.presentation.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator

@Composable
fun F1NavigationRailBar(
    modifier: Modifier = Modifier,
    tabNavigator: TabNavigator,
    navRailItems: List<Tab>,
) {
    val painter: Painter? = null

    NavigationRail(
        modifier = modifier.fillMaxHeight().alpha(0.95F),
        containerColor = MaterialTheme.colorScheme.surface,
        header = {},
        contentColor = MaterialTheme.colorScheme.onSurface,
    ) {
        navRailItems.forEach { item ->
            NavigationRailItem(
                modifier = Modifier.padding(vertical = 12.dp),
                icon = {
                    item.options.icon?.let {

                        //Todo re-write when will be icons added
                        if (painter != null) {
                            Icon(
                                painter = painter,
                                contentDescription = item.options.title
                    //                            painter = if (isSelected) {
                    //                                FilledIcon(item)
                    //                            } else {
                    //                                it
                    //                            },
                    //                            contentDescription = item.options.title,
                            )
                        }
                    }
                },
                label = { Text(text = item.options.title) },
                alwaysShowLabel = true,
                selected = tabNavigator.current == item,
                onClick = { tabNavigator.current = item },
            )
        }
    }
}