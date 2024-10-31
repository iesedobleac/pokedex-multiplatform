package com.isaacdelosreyes.pokedexmultiplatform.core.utils

import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pokemon.OfficialArtwork
import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pokemon.Other
import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pokemon.Sprites

fun getFakeOfficialArtwork() = OfficialArtwork(
    frontDefault = ""
)

fun getFakeSprites() = Sprites(
    other = getFakeOther()
)

fun getFakeOther() = Other(
    officialArtwork = getFakeOfficialArtwork()
)