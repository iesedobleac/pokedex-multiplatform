package com.isaacdelosreyes.pokedexmultiplatform.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.remote.pokemon.toDomain
import com.isaacdelosreyes.pokedexmultiplatform.core.data.repository.PokedexRepository
import com.isaacdelosreyes.pokedexmultiplatform.core.utils.NetWorkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(private val pokedexRepository: PokedexRepository) : ViewModel() {

    var state by mutableStateOf(HomeState())

    init {
        getPokemonsPaginated()
    }

    private fun getPokemonsPaginated() {
        viewModelScope.launch(Dispatchers.Default) {
            pokedexRepository.getPokemonsPaginated().collectLatest { response ->
                when (response) {
                    is NetWorkResult.Success -> {
                        val pokemons = state.pokemons.toMutableList()

                        response.data?.results?.forEach { result ->
                            result.name?.let { name ->
                                val pokemonInfo = pokedexRepository.getPokemonInfo(
                                    name = name
                                )

                                if (pokemonInfo is NetWorkResult.Success) {
                                    pokemonInfo.data?.let { pokemonDto ->
                                        pokemons.add(pokemonDto.toDomain())
                                    }
                                }
                            }
                        }

                        state = state.copy(
                            pokemons = pokemons,
                            isLoading = false
                        )
                    }

                    is NetWorkResult.Error -> {
                        state = state.copy(
                            error = response.exception,
                            isLoading = false
                        )
                    }

                    is NetWorkResult.Loading -> {
                        //no-op
                    }
                }
            }
        }
    }
}