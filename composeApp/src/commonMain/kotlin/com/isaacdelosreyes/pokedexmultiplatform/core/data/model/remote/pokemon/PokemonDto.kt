package com.isaacdelosreyes.pokedexmultiplatform.core.data.model.remote.pokemon

import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pokemon.Pokemon
import com.isaacdelosreyes.pokedexmultiplatform.core.utils.getFakeSprites
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDto(
    @SerialName("name")
    val name: String?,
    @SerialName("sprites")
    val sprites: SpritesDto?
)

fun PokemonDto.toDomain() =
    Pokemon(
        name = name.orEmpty(),
        sprites = sprites
            ?.toDomain()
            ?: getFakeSprites()
    )




