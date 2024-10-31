package com.isaacdelosreyes.pokedexmultiplatform.home.presentation

import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pokemon.Pokemon

data class HomeState(
    val isLoading: Boolean = true,
    val pokemons: List<Pokemon> = emptyList(),
    val error: String? = null
)