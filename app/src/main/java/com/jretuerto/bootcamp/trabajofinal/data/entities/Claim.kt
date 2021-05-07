package com.jretuerto.bootcamp.trabajofinal.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Claim(
    val claimId: Int,
    val insertDate: String,
    val sumary: String,
    val status: String,
): Parcelable
