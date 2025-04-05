package com.igoparking

import com.igoparking.adapter.out.rds.annotation.EnableRdsAdapter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@EnableRdsAdapter
@SpringBootApplication(scanBasePackages = ["com.igoparking"])
@ConfigurationPropertiesScan
class SpringBootTestApplication
