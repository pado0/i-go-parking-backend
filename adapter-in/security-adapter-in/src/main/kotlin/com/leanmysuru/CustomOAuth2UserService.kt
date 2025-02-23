package com.leanmysuru

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service

@Service
class CustomOAuth2UserService : OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User {
        val oAuth2UserService = DefaultOAuth2UserService()
        val oAuth2User = oAuth2UserService.loadUser(userRequest)

        val registrationId = userRequest?.clientRegistration?.registrationId
        val userNameAttributeName = userRequest?.clientRegistration
            ?.providerDetails?.userInfoEndpoint?.userNameAttributeName


        val oAuth2Attributes = OAuth2Attribute.of(
            provider = registrationId,
            attributeKey = userNameAttributeName,
            attributes = oAuth2User.attributes,
        )

        val email = oAuth2User.attributes["email"].toString()
        return DefaultOAuth2User(
            listOf(SimpleGrantedAuthority("ROLE_USER")),
            oAuth2User.attributes,
            email
        )
    }
}