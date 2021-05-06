package com.hexadefence.keycloakrestclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CmdLineRunner implements CommandLineRunner {

    @Autowired
    OAuth2RestOperations auth2RestOperations;

    @Override
    public void run(String... args) throws Exception {

            auth2RestOperations.getAccessToken();
            auth2RestOperations.getForObject("http://localhost:8080/auth/admin/realms/hexadefence/users", Object.class);

    }
}
