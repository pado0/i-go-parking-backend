package com.igoparking.adapter.out.rds.annotation

import com.igoparking.adapter.out.rds.config.RdsDbConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@ComponentScan(basePackages = ["com.igoparking.adapter.out.rds"])
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(RdsDbConfig::class)
annotation class EnableRdsAdapter()
