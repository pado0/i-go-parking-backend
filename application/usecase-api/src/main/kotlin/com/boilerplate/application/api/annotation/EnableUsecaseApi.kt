package com.boilerplate.application.api.annotation

import com.boilerplate.application.api.config.UsecaseApiConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(UsecaseApiConfig::class)
annotation class EnableUsecaseApi()
