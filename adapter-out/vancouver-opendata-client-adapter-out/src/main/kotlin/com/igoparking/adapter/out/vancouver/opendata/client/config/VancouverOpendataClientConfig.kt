package com.igoparking.adapter.out.vancouver.opendata.client.config

import com.igoparking.adapter.out.feign.annotation.EnableFeignAdapter
import org.springframework.context.annotation.ComponentScan

@EnableFeignAdapter
@ComponentScan(basePackages = ["com.igoparking.adapter.out.vancouver.opendata.client"])
class VancouverOpendataClientConfig
