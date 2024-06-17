package com.opliska.f1calendarapplication.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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