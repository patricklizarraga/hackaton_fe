package com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val url: String

) : Parcelable