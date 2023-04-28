package com.Keycloak.AuthDelication.service;

import com.Keycloak.AuthDelication.config.KeyCloakConfig;
import com.Keycloak.AuthDelication.pojo.Credentials;
import com.Keycloak.AuthDelication.pojo.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Collections;

@Service
@Slf4j
public class KeyCloakService {



    public Response addUser(UserDTO userDTO)
    {
        //log.info("before creating user Resource");
        UsersResource userResource = KeyCloakConfig.getInstance().realm("SpringBootCloak").users();
        //log.info("after getting user resource");
        CredentialRepresentation credential = Credentials.createPasswordCredentials(userDTO.getPassword());
        UserRepresentation user = new UserRepresentation();
        user.setUsername(userDTO.getUserName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmailId());
        user.setCredentials(Collections.singletonList(credential));
        user.setEnabled(true);
        log.info("before create method");
        Response response = userResource.create(user);
        log.info("after create method");

        if(response.getStatus() == 201)
            return response;

        log.info(response.getStatus()+"");
        return response;

    }



}
