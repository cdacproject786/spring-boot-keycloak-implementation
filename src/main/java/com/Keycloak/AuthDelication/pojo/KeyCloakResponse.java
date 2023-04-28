package com.Keycloak.AuthDelication.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KeyCloakResponse {

    private String access_token;
    private String refresh_token;
    private String session_state;
    private String scope;
    private String token_type;
    private double expires_in;
    private double refresh_expires_in;

}
