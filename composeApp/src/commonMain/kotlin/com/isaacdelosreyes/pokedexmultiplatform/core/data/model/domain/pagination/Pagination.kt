package com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pagination

import com.isaacdelosreyes.pokedexmultiplatform.core.data.model.domain.pagination.Result

data class Pagination(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)