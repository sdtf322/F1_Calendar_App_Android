package com.opliska.f1calendarapplication.data.model

import com.google.firebase.database.PropertyName

data class Circuit(
    @PropertyName("Location") val location: Location? = null,
    val circuitId: String? = null,
    val circuitName: String? = null,
    val url: String? = null
)