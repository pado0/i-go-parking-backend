package com.igoparking.adapter.out.feign.circuit

interface CircuitBreaker {
    fun <T> run(
        name: String,
        block: () -> T,
    ): Result<T>
}

fun <T> circuit(
    name: String = path().getOrDefault("default-circuit-breaker").replacePathVariables(),
    circuitBreaker: CircuitBreaker = DefaultCircuitBreakerProvider.get(),
    block: () -> T,
): Result<T> = circuitBreaker.run(name, block)

fun <T> Result<T>.fallback(block: () -> T): Result<T> =
    if (this.isSuccess) {
        this
    } else {
        runCatching { block() }
    }

fun <T> Result<T>.fallbackIfOpened(block: () -> T): Result<T> =
    when (this.exceptionOrNull()) {
        is CircuitBreakerOpenedException -> runCatching { block() }
        else -> this
    }
