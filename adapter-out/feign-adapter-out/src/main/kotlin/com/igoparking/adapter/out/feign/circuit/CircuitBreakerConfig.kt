package com.igoparking.adapter.out.feign.circuit

import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CircuitBreakerConfig {
    @Bean
    fun circuitBreaker(circuitBreakerFactory: CircuitBreakerFactory<*, *>) = DefaultCircuitBreaker(factory = circuitBreakerFactory)

    @Bean
    fun defaultCircuitBreakerProvider(circuitBreaker: CircuitBreaker) = DefaultCircuitBreakerProvider(circuitBreaker = circuitBreaker)
}
