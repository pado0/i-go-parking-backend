package com.leanmysuru.annotation

import com.leanmysuru.config.RdsDbConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@ComponentScan(basePackages = ["com.leanmysuru"])
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(RdsDbConfig::class)
annotation class EnableRdsAdapter()
