package com.leanmysuru.annotation

import com.leanmysuru.config.WebAdapterConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(WebAdapterConfig::class)
annotation class EnableWebAdapter