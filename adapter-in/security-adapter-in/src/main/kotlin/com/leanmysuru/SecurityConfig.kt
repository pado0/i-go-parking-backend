import com.leanmysuru.CustomOAuth2UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val customOAuth2UserService: CustomOAuth2UserService,
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { configurer -> configurer.disable() }
            .formLogin { form -> form.disable() }
            .oauth2Login { oauth2 -> oauth2
                .loginPage("/login")
                .defaultSuccessUrl("http://localhost:8080")
                .failureUrl("/failure")
                .userInfoEndpoint { user -> user.userService(customOAuth2UserService) } }

        return http.build()
    }
}
