package com.opliska.f1calendarapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.opliska.f1calendarapplication.ui.theme.F1CalendarApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F1CalendarApplicationTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "race_list",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("race_list") { RaceListScreen() }
            composable("option1") { Option1Screen() }
            composable("option2") { Option2Screen() }
            composable("option3") { Option3Screen() }
            composable("option4") { Option4Screen() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("Race List", Icons.Default.List, "race_list"),
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
    Text(text = "Race List Screen")
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    F1CalendarApplicationTheme {
        MainScreen()
    }
}
