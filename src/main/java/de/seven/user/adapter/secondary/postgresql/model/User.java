package de.seven.user.adapter.secondary.postgresql.model;

import de.seven.user.domain.model.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "User")
@Table(name= "\"user\"")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String userId;
    String firstname;
    String lastname;
    String email;
    String password;
    Date createdAt;
    Type type;

    public de.seven.user.domain.model.User toDomainUser() {
        return de.seven.user.domain.model.User.builder()
                .userId(userId)
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .password(password)
                .createdAt(createdAt)
                .type(type)
                .build();
    }

    public static User fromDomainUser(de.seven.user.domain.model.User domainUser) {
        return User.builder()
                .userId(domainUser.getUserId())
                .firstname(domainUser.getFirstname())
                .lastname(domainUser.getLastname())
                .email(domainUser.getEmail())
                .password(domainUser.getPassword())
                .createdAt(domainUser.getCreatedAt())
                .type(domainUser.getType())
                .build();
    }
}