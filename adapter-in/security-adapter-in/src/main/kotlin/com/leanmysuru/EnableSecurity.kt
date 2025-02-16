package com.leanmysuru

import SecurityConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(SecurityConfig::class)
annotation class EnableSecurity()
