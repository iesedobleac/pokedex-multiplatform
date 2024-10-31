package com.isaacdelosreyes.pokedexmultiplatform.core.data.model.remote.pagination

import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pagination.Pagination
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaginationDto(
    @SerialName("count")
    val count: Int?,
    @SerialName("next")
    val next: String?,
    @SerialName("previous")
    val previous: String?,
    @SerialName("results")
    val results: List<ResultDto>?
)

fun PaginationDto.toDomain() = Pagination(
    count = count ?: 0,
    next = next.orEmpty(),
    previous = previous.orEmpty(),
    results = results?.map { it.toDomain() }.orEmpty()
)