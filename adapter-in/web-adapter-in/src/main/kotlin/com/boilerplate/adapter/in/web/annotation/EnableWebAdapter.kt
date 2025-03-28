package com.boilerplate.adapter.`in`.web.annotation

import com.boilerplate.adapter.`in`.web.config.WebAdapterConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(WebAdapterConfig::class)
annotation class EnableWebAdapter
