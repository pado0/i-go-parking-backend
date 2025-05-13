package com.igoparking.adapter.out.vancouver.public.client.annotation

import com.igoparking.adapter.out.feign.config.FeignConfig
import com.igoparking.adapter.out.vancouver.public.client.config.VancouverPublicClientConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(
    FeignConfig::class,
    VancouverPublicClientConfig::class,
)
annotation class EnableVancouverPublicClient
