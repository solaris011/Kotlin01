package com.solera.contador

data class CharacterResponse(
    val results: List<Characters>
)

 data class Characters(
        val id: Int,
        val name: String,
        val species: String,
        val image: String,
 )
