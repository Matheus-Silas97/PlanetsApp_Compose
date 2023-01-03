package com.matheussilas97.planetsapp_jetpackcompose.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Planets(val name: String, val description: String, val image: Int) : Parcelable