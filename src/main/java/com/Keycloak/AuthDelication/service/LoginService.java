package com.Keycloak.AuthDelication.service;

import com.Keycloak.AuthDelication.entity.User;
import com.Keycloak.AuthDelication.pojo.KeyCloakResponse;
import com.Keycloak.AuthDelication.pojo.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class LoginService {

    @Autowired
    private RestTemplate template;
    public KeyCloakResponse loginUser(User user)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("grant_type","password");
        map.add("client_id","SpringBoot-Keycloak-client");
        map.add("username",user.getUsername());
        map.add("password",user.getPassword());

        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(map,headers);
        ResponseEntity<KeyCloakResponse> response =  template.exchange("http://localhost:8080/realms/SpringBootCloak/protocol/openid-connect/token",HttpMethod.POST,entity, KeyCloakResponse.class);
        if(response.getStatusCode() == HttpStatus.UNAUTHORIZED || response.getStatusCode() == HttpStatus.FORBIDDEN)
            return null;
        else
            return response.getBody();
    }
}
