package com.igoparking.domain.unit

@JvmInline
value class Dollar(
    val value: Double,
)

fun String.toDollar(): Dollar = Dollar(this.replace("$", "").trim().toDouble())
