package com.Keycloak.AuthDelication.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    private final String grant_type = "password";
    private final String client_id  = "SpringBoot-Keycloak-client";

    private String username;
    private String password;
}
