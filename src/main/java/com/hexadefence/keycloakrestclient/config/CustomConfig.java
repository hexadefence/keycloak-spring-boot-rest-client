package com.hexadefence.keycloakrestclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableOAuth2Client
public class CustomConfig {

    private String tokenUrl = "http://localhost:8080/auth/realms/hexadefence/protocol/openid-connect/token";

    @Bean
    protected OAuth2ProtectedResourceDetails resource(){
        ResourceOwnerPasswordResourceDetails resource;
        resource = new ResourceOwnerPasswordResourceDetails();

        resource.setAccessTokenUri(tokenUrl);
        resource.setClientId("rest-client");
        resource.setGrantType("password");
        resource.setUsername("hexa");
        resource.setPassword("hexa");
        return resource;
    }

    @Bean
    public OAuth2RestOperations restTemplate() {
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(atr));
    }

}













//    @Bean
//    protected OAuth2ProtectedResourceDetails resource(){
//        ResourceOwnerPasswordResourceDetails resource;
//        resource = new ResourceOwnerPasswordResourceDetails();
//
////        List scopes = new ArrayList<String>(2);
////        scopes.add("write");
////        scopes.add("read");
//        resource.setAccessTokenUri(tokenUrl);
//        resource.setClientId("test-client");
////        resource.setClientSecret("restapp");
//        resource.setGrantType("password");
////        resource.setScope(scopes);
//        resource.setUsername("hexa");
//        resource.setPassword("hexa");
//        return resource;
//    }
