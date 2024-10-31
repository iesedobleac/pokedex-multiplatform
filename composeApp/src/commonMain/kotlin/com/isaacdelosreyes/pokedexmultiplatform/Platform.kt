package com.isaacdelosreyes.pokedexmultiplatform

sealed class PlatformSealed(val name: String) {

    data object Android : PlatformSealed("Android")
    data object IOS : PlatformSealed("iOS")
    data object Desktop : PlatformSealed("Desktop")
    data object Browser : PlatformSealed("Browser")
}

expect fun getPlatformSealed(): PlatformSealed