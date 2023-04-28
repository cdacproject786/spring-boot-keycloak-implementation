package com.Keycloak.AuthDelication.config;

import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class KeyCloakConfig {

    public static Keycloak keycloak = null;
    final static String serverUrl = "http://localhost:8080/"; // find the server url
    //" scheme://server:port/auth/realms/realmname"
    final static String realm = "SpringBootCloak";
    final static String clientId = "SpringBoot-Keycloak-client";
    final static String clientSecret = "4cd17341-b9fa-45e8-b5b3-5ede6ed4653d";
    final static String username = "user1";
    final static String password = "password";

    public KeyCloakConfig() {
    }

    @Bean
    public static Keycloak getInstance()
    {
        log.info("before creating bean");
        if(keycloak == null)
        {
            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(username)
                    .password(password)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .resteasyClient(new ResteasyClientBuilder()
                            .connectionPoolSize(10)
                            .build()
                    ).build();
        }

        //log.info("after creating bean and before returning it");
        return keycloak;
    }
}
