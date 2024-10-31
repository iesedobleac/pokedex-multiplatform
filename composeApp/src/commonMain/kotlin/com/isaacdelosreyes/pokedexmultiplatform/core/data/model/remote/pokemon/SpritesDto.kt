package com.isaacdelosreyes.pokedexmultiplatform.core.data.model.remote.pokemon

import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pokemon.Sprites
import com.isaacdelosreyes.pokedexmultiplatform.core.utils.getFakeOther
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpritesDto(
    @SerialName("other")
    val other: OtherDto?
)

fun SpritesDto.toDomain() =
    Sprites(
        other = other
            ?.toDomain()
            ?: getFakeOther()
    )
