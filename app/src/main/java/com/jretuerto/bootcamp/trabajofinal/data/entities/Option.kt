package com.jretuerto.bootcamp.trabajofinal.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Option(
    val imgResource: Int,
    val title: String
): Parcelable
