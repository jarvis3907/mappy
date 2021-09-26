package de.smava.homework.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final JwtTokenStore tokenStore;
    private final AuthenticationManager authenticationManager;
    private final JwtAccessTokenConverter accessTokenConverter;

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        configurer.inMemory().withClient(SecurityConstants.CLIENT_ID).secret(SecurityConstants.CLIENT_SECRET)
                .authorizedGrantTypes(SecurityConstants.GRANT_TYPE_PASSWORD, SecurityConstants.AUTHORIZATION_CODE,
                        SecurityConstants.REFRESH_TOKEN, SecurityConstants.IMPLICIT)
                .scopes(SecurityConstants.SCOPE_READ, SecurityConstants.SCOPE_WRITE)
                .accessTokenValiditySeconds(SecurityConstants.ACCESS_TOKEN_VALIDITY_SECONDS)
                .refreshTokenValiditySeconds(SecurityConstants.REFRESH_TOKEN_VALIDITY_SECONDS)
                .resourceIds(SecurityConstants.RESOURCE_ID);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
                .accessTokenConverter(accessTokenConverter);
    }
}