package securitywithjwt.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import securitywithjwt.common.util.Permission;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class HttpSecurityConfig {
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement(sessionManagementConfigurer -> sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authenticationProvider(authenticationProvider);
        http.authorizeHttpRequests(authConfig -> {
            /* Public resources*/
            authConfig.requestMatchers(HttpMethod.POST,
                                       "/auth/authenticate")
                      .permitAll();
            authConfig.requestMatchers(HttpMethod.GET,
                                       "/auth/public-access")
                      .permitAll();
            authConfig.requestMatchers("/error")
                      .permitAll();
            /* Protected resources*/
            authConfig.requestMatchers(HttpMethod.GET,
                                       "/products")
                      .hasAuthority(Permission.READ_ALL_PRODUCTS.name());
            authConfig.requestMatchers(HttpMethod.POST,
                                       "/products")
                      .hasAuthority(Permission.SAVE_ONE_PRODUCT.name());

            authConfig.anyRequest()
                      .denyAll();
        });
        return http.build();
    }
}
