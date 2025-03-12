package com.leanmysuru

import com.leanmysuru.annotation.EnableRdsAdapter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@EnableRdsAdapter
@SpringBootApplication(scanBasePackages = ["com.leanmysuru"])
@ConfigurationPropertiesScan
class SpringBootTestApplication