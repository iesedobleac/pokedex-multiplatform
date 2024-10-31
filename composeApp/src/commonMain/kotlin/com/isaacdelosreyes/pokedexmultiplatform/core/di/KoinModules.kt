package com.isaacdelosreyes.pokedexmultiplatform.core.di

import com.isaacdelosreyes.pokedexmultiplatform.core.data.repository.PokedexRepository
import com.isaacdelosreyes.pokedexmultiplatform.core.data.repository.PokedexRepositoryImpl
import com.isaacdelosreyes.pokedexmultiplatform.home.presentation.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val provideRepositoryModule = module {
    single<PokedexRepository> { PokedexRepositoryImpl(get()) }
}

val provideViewModelModule = module {
    single {
        HomeViewModel(get())
    }
}

val provideHttpClientModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    json = Json { ignoreUnknownKeys = true },
                    contentType = ContentType.Any
                )
            }
        }
    }
}

val appModule = listOf(
    provideRepositoryModule,
    provideViewModelModule,
    provideHttpClientModule
)