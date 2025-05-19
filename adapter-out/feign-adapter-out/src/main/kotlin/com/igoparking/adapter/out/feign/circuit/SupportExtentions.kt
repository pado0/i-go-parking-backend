package com.igoparking.adapter.out.feign.circuit

import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

fun path(): Result<String> =
    when (val attributes = RequestContextHolder.currentRequestAttributes()) {
        is ServletRequestAttributes -> Result.success(attributes.request.servletPath)
        else -> Result.failure(IllegalStateException())
    }

fun String.replacePathVariables(to: String = "{id}"): String =
    this
        .split("/")
        .joinToString("/") {
            when (it.isNumber()) {
                true -> to
                false -> it
            }
        }

private fun String.isNumber(): Boolean = this.isNotBlank() && regexNumber.matches(this)

private val regexNumber = Regex("^\\d*$")
