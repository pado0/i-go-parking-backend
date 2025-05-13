package com.igoparking

import com.igoparking.adapter.out.vancouver.public.client.annotation.EnableVancouverPublicClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication(scanBasePackages = ["com.igoparking"])
@ConfigurationPropertiesScan
@EnableVancouverPublicClient
@EnableFeignClients
class SpringBootTestApplication
