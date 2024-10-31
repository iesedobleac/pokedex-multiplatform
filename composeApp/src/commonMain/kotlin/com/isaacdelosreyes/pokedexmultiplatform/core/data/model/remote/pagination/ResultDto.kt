package com.isaacdelosreyes.pokedexmultiplatform.core.data.model.remote.pagination

import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pagination.Result
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultDto(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)

fun ResultDto.toDomain() = Result(
    name = name.orEmpty(),
    url = url.orEmpty()
)