package com.isaacdelosreyes.pokedexmultiplatform.core.data.model.remote.pokemon

import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pokemon.OfficialArtwork
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OfficialArtworkDto(
    @SerialName("front_default")
    val frontDefault: String?
)

fun OfficialArtworkDto.toDomain() =
    OfficialArtwork(
        frontDefault = frontDefault.orEmpty()
    )