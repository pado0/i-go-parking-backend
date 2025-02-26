package com.leanmysuru.config

import com.leanmysuru.annotation.EnableUsecaseApiService
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.leanmysuru"])
@EnableUsecaseApiService
class WebAdapterConfig {
}