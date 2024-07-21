package com.opliska.shared.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.opliska.shared.core.presentation.presentation.components.F1NavigationRailBar
import com.opliska.shared.core.presentation.presentation.components.F1Tab
import com.opliska.shared.core.presentation.utils.FilledIcon

class MainScreen : Screen {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    @Composable
    override fun Content() {
        val windowSizeClass = calculateWindowSizeClass()
        val useNavRail = windowSizeClass.widthSizeClass > WindowWidthSizeClass.Compact

        TabNavigator(
            F1Tab.RaceListTab,
        ) {

            if (useNavRail) {
                Row {
                    F1NavigationRailBar(
                        tabNavigator = it,
                        navRailItems = listOf(
                            F1Tab.RaceListTab,
                            F1Tab.DriverListTab,
                            F1Tab.ConstructorListTab,
                        ),
                    )
                    CurrentScreen()
                }
            } else {
                Scaffold(
                    content = { innerPadding ->
                        Box(
                            modifier = Modifier
                                .padding(innerPadding),
                        ) {
                            CurrentScreen()
                        }
                    },
                    bottomBar = {
                        BottomNavigation(
                            backgroundColor = MaterialTheme.colorScheme.background,
                        ) {
                            TabNavigationItem(F1Tab.RaceListTab)
                            TabNavigationItem(F1Tab.DriverListTab)
                            TabNavigationItem(F1Tab.ConstructorListTab)
                        }
                    },
                )
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val isSelected = tabNavigator.current == tab

    BottomNavigationItem(
        modifier = Modifier.offset(
            x = when (tab.options.index) {
                (0u).toUShort() -> 0.dp
                (1u).toUShort() -> (-24).dp
                (2u).toUShort() -> 24.dp
                else -> 0.dp
            },
        ),
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let {
                (if (isSelected) {
                    FilledIcon(tab)
                } else {
                    it
                })?.let { it1 ->
                    Icon(
                        painter = it1,
                        contentDescription = tab.options.title,
                        tint = if (isSelected) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onBackground
                        },
                    )
                }
            }
        },
    )
}