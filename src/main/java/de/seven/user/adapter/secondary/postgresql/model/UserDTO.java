package de.seven.user.adapter.secondary.postgresql.model;

import de.seven.user.domain.model.Type;
import de.seven.user.domain.model.User;
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
public class UserDTO {
    @Id
    String userId;
    String firstname;
    String lastname;
    String email;
    String password;
    Date createdAt;
    Type type;

    public User toDomainUser() {
        return User.builder()
                .userId(userId)
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