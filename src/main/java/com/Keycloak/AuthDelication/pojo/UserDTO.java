package com.Keycloak.AuthDelication.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class UserDTO {

    private String userName;
    private String emailId;
    private String password;
    private String firstName;
    private String lastName;

}
