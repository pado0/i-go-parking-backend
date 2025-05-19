package com.igoparking

import com.igoparking.adapter.out.vancouver.opendata.client.annotation.EnableVancouverOpendataClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication(scanBasePackages = ["com.igoparking"])
@ConfigurationPropertiesScan
@EnableVancouverOpendataClient
@EnableFeignClients
class SpringBootTestApplication
