package com.igoparking.adapter.out.feign.config

import feign.Logger
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignFormatterRegistrar
import org.springframework.context.annotation.Bean
import org.springframework.format.FormatterRegistry
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar
import org.springframework.retry.annotation.EnableRetry

@EnableRetry
@EnableFeignClients(basePackages = ["com.igoparking.adapter.out.feign"])
class FeignConfig {
    /**
     * LocalDate, LocalDateTime, LocalTime in RequestParam, formatting ISO
     *
     * @see org.springframework.web.bind.annotation.RequestParam
     */
    @Bean
    fun localDateFeignFormatterRegister(): FeignFormatterRegistrar =
        FeignFormatterRegistrar { registry: FormatterRegistry ->
            val registrar = DateTimeFormatterRegistrar()
            registrar.setUseIsoFormat(true)
            registrar.registerFormatters(registry)
        }

    @Bean
    fun feignLoggerLevel(): Logger.Level = Logger.Level.FULL
}
