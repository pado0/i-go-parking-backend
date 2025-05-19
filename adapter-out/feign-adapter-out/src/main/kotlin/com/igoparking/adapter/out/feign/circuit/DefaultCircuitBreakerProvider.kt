package com.igoparking.adapter.out.feign.circuit

class DefaultCircuitBreakerProvider(
    circuitBreaker: CircuitBreaker,
) {
    init {
        Companion.circuitBreaker = circuitBreaker
    }

    companion object {
        private lateinit var circuitBreaker: CircuitBreaker

        fun get(): CircuitBreaker = circuitBreaker
    }
}
