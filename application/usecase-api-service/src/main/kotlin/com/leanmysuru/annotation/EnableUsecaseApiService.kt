package com.leanmysuru.annotation

import com.leanmysuru.config.UsecaseApiServiceConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(UsecaseApiServiceConfig::class)
annotation class EnableUsecaseApiService()
