package com.lucas.barbosa.desafioindra.data.local.models

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("name")
    val name: String
)