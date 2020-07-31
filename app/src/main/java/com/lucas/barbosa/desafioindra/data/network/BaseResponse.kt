package com.lucas.barbosa.desafioindra.data.network

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: Any,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)