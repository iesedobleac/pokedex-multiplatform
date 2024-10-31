package com.isaacdelosreyes.pokedexmultiplatform.core.data.model.remote.pokemon

import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pokemon.Other
import com.isaacdelosreyes.pokedexmultiplatform.core.utils.getFakeOfficialArtwork
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OtherDto(
    @SerialName("official-artwork")
    val officialArtwork: OfficialArtworkDto?
)

fun OtherDto.toDomain() =
    Other(
        officialArtwork = officialArtwork
            ?.toDomain()
            ?: getFakeOfficialArtwork()
    )