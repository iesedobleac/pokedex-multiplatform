package com.isaacdelosreyes.pokedexmultiplatform

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.util.DebugLogger
import com.isaacdelosreyes.pokedexmultiplatform.core.di.appModule
import com.isaacdelosreyes.pokedexmultiplatform.navigation.NavigationHost
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    setSingletonImageLoaderFactory {
        ImageLoader.Builder(it)
            .logger(DebugLogger())
            .build()
    }

    KoinApplication(
        application = {
            modules(appModule)
        }
    ) {

        MaterialTheme {
            NavigationHost()
        }
    }
}