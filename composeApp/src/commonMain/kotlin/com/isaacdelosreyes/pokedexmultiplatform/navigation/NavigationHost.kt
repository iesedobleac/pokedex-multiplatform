package com.isaacdelosreyes.pokedexmultiplatform.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.isaacdelosreyes.pokedexmultiplatform.home.presentation.HomeScreen

@Composable
fun NavigationHost(navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {

        composable(route = Routes.Home.route) {
            HomeScreen()
        }
    }
}