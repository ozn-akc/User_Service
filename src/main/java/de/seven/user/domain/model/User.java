package de.seven.user.domain.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Getter
public class User {
    String userId;
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