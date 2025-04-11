package com.igoparking.adapter.out.feign.annotation

import com.igoparking.adapter.out.feign.config.FeignConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@ComponentScan(basePackages = ["com.igoparking.adapter.out.feign"])
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(FeignConfig::class)
annotation class EnableFeignAdapter
