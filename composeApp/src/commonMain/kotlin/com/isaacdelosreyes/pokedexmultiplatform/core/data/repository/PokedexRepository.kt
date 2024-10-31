package com.isaacdelosreyes.pokedexmultiplatform.core.data.repository

import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.remote.pagination.PaginationDto
import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.remote.pokemon.PokemonDto
import com.isaacdelosreyes.pokedexmultiplatform.core.utils.NetWorkResult
import com.isaacdelosreyes.pokedexmultiplatform.core.utils.toResultFlow
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {
    fun getPokemonsPaginated(): Flow<NetWorkResult<PaginationDto?>>
    suspend fun getPokemonInfo(name: String): NetWorkResult<PokemonDto?>
}

class PokedexRepositoryImpl(
    private val httpClient: HttpClient
) : PokedexRepository {

    override fun getPokemonsPaginated(): Flow<NetWorkResult<PaginationDto?>> {
        return toResultFlow {
            val url = "https://pokeapi.co/api/v2/pokemon"
            val response = httpClient.get(urlString = url) {
                parameter("limit", 20)
            }
            NetWorkResult.Success(_data = response.body<PaginationDto>())
        }
    }

    override suspend fun getPokemonInfo(name: String): NetWorkResult<PokemonDto?> {
        val url = "https://pokeapi.co/api/v2/pokemon/$name"
        val response = httpClient.get(urlString = url)
        return try {
            NetWorkResult.Success(_data = response.body<PokemonDto>())

        } catch (e: Exception) {
            NetWorkResult.Error(_data = null, exception = e.message ?: "Error")
        }
    }
}