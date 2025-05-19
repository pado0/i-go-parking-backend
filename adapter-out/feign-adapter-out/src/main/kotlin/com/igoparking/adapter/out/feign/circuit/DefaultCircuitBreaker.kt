package com.igoparking.adapter.out.feign.circuit

import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory

class DefaultCircuitBreaker(
    private val factory: CircuitBreakerFactory<*, *>,
) : CircuitBreaker {
    override fun <T> run(
        name: String,
        block: () -> T,
    ): Result<T> =
        runCatching {
            factory.create(name).run(block) { e -> throw e.changeToCircuitBreakerOpenedExceptionIfOpened() }
        }
}
