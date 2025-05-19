package com.igoparking.adapter.out.feign.dto

class CircuitBreakerResult<out T>(
    val data: T,
    override val isOpened: Boolean = false,
) : CircuitBreakerApplied {
    fun applyIfOpened(block: () -> Unit): CircuitBreakerResult<T> {
        if (isOpened) {
            block()
        }
        return this
    }
}
