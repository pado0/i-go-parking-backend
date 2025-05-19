package com.igoparking.adapter.out.vancouver.opendata.client.annotation

import com.igoparking.adapter.out.feign.config.FeignConfig
import com.igoparking.adapter.out.vancouver.opendata.client.config.VancouverOpendataClientConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(
    FeignConfig::class,
    VancouverOpendataClientConfig::class,
)
annotation class EnableVancouverOpendataClient
