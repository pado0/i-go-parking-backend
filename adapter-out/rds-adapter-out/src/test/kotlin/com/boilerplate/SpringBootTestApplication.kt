package com.boilerplate

import com.boilerplate.adapter.out.rds.annotation.EnableRdsAdapter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@EnableRdsAdapter
@SpringBootApplication(scanBasePackages = ["com.boilerplate"])
@ConfigurationPropertiesScan
class SpringBootTestApplication