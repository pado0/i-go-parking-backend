package com.igoparking.adapter.`in`.web.config

import com.igoparking.application.api.annotation.EnableUsecaseApi
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.igoparking.adapter.in.web"])
@EnableUsecaseApi
class WebAdapterConfig
