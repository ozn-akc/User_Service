package de.seven.user.domain.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class User {
    Integer userId;
    String firstname;
    String lastname;
    String email;
    String password;
    Date createdAt;
    Type type;

    public boolean isAHost(){
        return this.type != Type.USER;
    }
}