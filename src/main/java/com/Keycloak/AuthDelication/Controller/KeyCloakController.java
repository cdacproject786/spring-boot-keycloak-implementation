package com.Keycloak.AuthDelication.Controller;

import com.Keycloak.AuthDelication.pojo.UserDTO;
import com.Keycloak.AuthDelication.service.KeyCloakService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class KeyCloakController {

    KeyCloakService keyCloakService;

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO)
    {
        Response response =  keyCloakService.addUser(userDTO);
        return ResponseEntity.status(response.getStatus()).build();
    }
}
