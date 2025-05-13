package com.igoparking.adapter.out.feign.config

import feign.Retryer
import org.springframework.context.annotation.Bean

class FeignRetryConfiguration {
    @Bean
    fun retry(): Retryer = Retryer.Default()
}
