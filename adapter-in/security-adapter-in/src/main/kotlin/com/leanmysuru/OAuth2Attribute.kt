package com.leanmysuru

data class OAuth2Attribute(
    val attributes: Map<String, Any>,
    val attributeKey: String?,
    val email: String,
    val name: String? = null,
    val picture: String? = null,
    val provider: String? = null,
) {

    companion object {
        fun of(
            attributeKey: String?,
            provider: String?,
            attributes: Map<String, Any>,
        ): OAuth2Attribute {
            return OAuth2Attribute(
                attributes = attributes,
                attributeKey = attributeKey,
                email = attributes["email"].toString(),
                provider = provider,
            )
        }
    }
}