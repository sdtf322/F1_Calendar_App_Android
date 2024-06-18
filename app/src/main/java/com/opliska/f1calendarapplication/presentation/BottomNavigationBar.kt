package com.opliska.f1calendarapplication.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.opliska.f1calendarapplication.presentation.race_list.RaceListScreen

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("Race List", Icons.AutoMirrored.Filled.List, "race_list"),
        BottomNavItem("Option 1", Icons.Default.Home, "option1"),
        BottomNavItem("Option 2", Icons.Default.Search, "option2"),
        BottomNavItem("Option 3", Icons.Default.Notifications, "option3"),
        BottomNavItem("Option 4", Icons.Default.AccountCircle, "option4")
    )

    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun RaceListScreen() {
    RaceListScreen()
}

@Composable
fun Option1Screen() {
    Text(text = "Option 1 Screen")
}

@Composable
fun Option2Screen() {
    Text(text = "Option 2 Screen")
}

@Composable
fun Option3Screen() {
    Text(text = "Option 3 Screen")
}

@Composable
fun Option4Screen() {
    Text(text = "Option 4 Screen")
}

data class BottomNavItem(val label: String, val icon: ImageVector, val route: String)