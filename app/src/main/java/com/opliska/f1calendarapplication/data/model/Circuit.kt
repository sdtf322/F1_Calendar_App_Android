package com.opliska.f1calendarapplication.data.model

import com.google.firebase.database.PropertyName

data class Circuit(
    @get:PropertyName("Location") @set:PropertyName("Location") var location: Location? = null,
    var circuitId: String? = null,
    var circuitName: String? = null,
    var url: String? = null
)