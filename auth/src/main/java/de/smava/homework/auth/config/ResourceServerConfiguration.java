package de.smava.homework.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
@EnableResourceServer
@RequiredArgsConstructor
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String API_URL_PATTERN = "/api/**";
    private final DefaultTokenServices tokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenServices(tokenServices).resourceId(SecurityConstants.RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.anonymous().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, API_URL_PATTERN).access(SecurityConstants.OAUTH2_HAS_SCOPE_WRITE)
                .antMatchers(HttpMethod.GET, API_URL_PATTERN).access(SecurityConstants.OAUTH2_HAS_SCOPE_READ)
                .antMatchers(HttpMethod.PUT, API_URL_PATTERN).access(SecurityConstants.OAUTH2_HAS_SCOPE_WRITE)
                .antMatchers(HttpMethod.DELETE, API_URL_PATTERN).access(SecurityConstants.OAUTH2_HAS_SCOPE_WRITE)
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}