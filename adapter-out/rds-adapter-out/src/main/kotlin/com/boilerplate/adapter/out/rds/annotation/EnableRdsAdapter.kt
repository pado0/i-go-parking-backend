package com.boilerplate.adapter.out.rds.annotation

import com.boilerplate.adapter.out.rds.config.RdsDbConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@ComponentScan(basePackages = ["com.boilerplate.adapter.out.rds"])
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(RdsDbConfig::class)
annotation class EnableRdsAdapter()
