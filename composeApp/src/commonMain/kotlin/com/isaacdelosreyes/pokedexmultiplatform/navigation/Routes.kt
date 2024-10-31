package com.isaacdelosreyes.pokedexmultiplatform.navigation

sealed class Routes(val route: String) {

    companion object {

        private const val HOME_ROUTE = "home"
    }

    data object Home: Routes(HOME_ROUTE)
}