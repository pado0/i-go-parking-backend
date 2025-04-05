package com.igoparking.adapter.`in`.common.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class LinkResponse<T>(
    data: ResponseData<T>?,
    status: HttpStatus = HttpStatus.OK,
) : ResponseEntity<Any>(data, status) {
    class ResponseData<T>(
        val data: PagedData<T>?,
    )

    class PagedData<T>(
        val items: List<T>,
        val prevLink: String?,
        val nextLink: String?,
    )
}
