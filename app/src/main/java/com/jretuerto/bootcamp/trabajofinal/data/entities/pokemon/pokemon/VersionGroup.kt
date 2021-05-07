package com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VersionGroup(
    val name: String,
    val url: String
) : Parcelable
