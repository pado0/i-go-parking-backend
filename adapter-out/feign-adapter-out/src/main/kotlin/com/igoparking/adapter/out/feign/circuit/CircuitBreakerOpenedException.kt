package com.igoparking.adapter.out.feign.circuit

import io.github.resilience4j.circuitbreaker.CallNotPermittedException

class CircuitBreakerOpenedException(
    message: String = "Circuit breaker is open",
) : RuntimeException(message)

fun Throwable.changeToCircuitBreakerOpenedExceptionIfOpened(): Throwable =
    when (this) {
        is CallNotPermittedException -> CircuitBreakerOpenedException()
        else -> this
    }
