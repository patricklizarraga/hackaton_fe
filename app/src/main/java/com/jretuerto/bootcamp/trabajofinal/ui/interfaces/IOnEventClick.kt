package com.jretuerto.bootcamp.trabajofinal.ui.interfaces

import com.jretuerto.bootcamp.trabajofinal.data.entities.Claim
import com.jretuerto.bootcamp.trabajofinal.data.entities.ClaimResponse
import com.jretuerto.bootcamp.trabajofinal.data.entities.Option

interface IOnEventClick {
    fun onClick(option: Option)
    fun onClick(claim: Claim)
}