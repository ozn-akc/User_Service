package de.seven.user.adapter.secondary.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import de.seven.user.domain.model.Type;
import de.seven.user.domain.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Document(collection = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    @Id
    String id;
    String firstname;
    String lastname;
    String email;
    String password;
    Date createdAt;
    Type type;

    public User toDomainUser() {
        return User.builder()
                .userId(id)
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .password(password)
                .createdAt(createdAt)
                .type(type)
                .build();
    }

    public static UserDTO fromDomainUser(User domainUser) {
        return UserDTO.builder()
                .id(domainUser.getUserId())
                .firstname(domainUser.getFirstname())
                .lastname(domainUser.getLastname())
                .email(domainUser.getEmail())
                .password(domainUser.getPassword())
                .createdAt(domainUser.getCreatedAt())
                .type(domainUser.getType())
                .build();
    }
}