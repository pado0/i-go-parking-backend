package com.boilerplate.adapter.`in`.web.config

import com.boilerplate.application.api.annotation.EnableUsecaseApi
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.boilerplate.application.api"])
@EnableUsecaseApi
class WebAdapterConfig {
}