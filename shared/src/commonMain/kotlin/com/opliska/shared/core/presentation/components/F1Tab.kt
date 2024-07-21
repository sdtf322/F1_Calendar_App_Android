package com.opliska.shared.core.presentation.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.opliska.shared.feature.constructors_list.ConstructorListScreen
import com.opliska.shared.feature.driver_list.DriverListScreen
import com.opliska.shared.feature.race_list.RaceListScreen

internal sealed class F1Tab {
    internal object RaceListTab : Tab {
        override val options: TabOptions
            @Composable
            get() {
                val title = "Race List"
                val icon = null

                return remember {
                    TabOptions(
                        index = 0u,
                        title = title,
                        icon = icon
                    )
                }
            }

        @Composable
        override fun Content() {
            RaceListScreen()
        }
    }

    internal object DriverListTab : Tab {
        override val options: TabOptions
            @Composable
            get() {
                val title = "Driver List"
                val icon = null

                return remember {
                    TabOptions(
                        index = 1u,
                        title = title,
                        icon = icon
                    )
                }
            }

        @Composable
        override fun Content() {
            DriverListScreen()
        }
    }

    internal object ConstructorListTab : Tab {
        override val options: TabOptions
            @Composable
            get() {
                val title = "Constructor list"
                val icon = null

                return remember {
                    TabOptions(
                        index = 2u,
                        title = title,
                        icon = icon
                    )
                }
            }

        @Composable
        override fun Content() {
            ConstructorListScreen()
        }
    }
}