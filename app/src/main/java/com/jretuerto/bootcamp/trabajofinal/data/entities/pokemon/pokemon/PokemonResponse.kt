package com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonResponse(
    val id: Int,
    val name: String,
    val order: Int,
    val form_order: Int,
    val is_default: Boolean,
    val is_battle_only: Boolean,
    val is_mega: Boolean,
    val form_name: String,
    val pokemon: Pokemon,
    val sprites: Sprites,
    val version_group: VersionGroup

) : Parcelable