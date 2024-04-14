package de.seven.user.adapter.secondary.postgresql;

import de.seven.user.adapter.secondary.postgresql.model.UserDTO;
import de.seven.user.application.adapter.secondary.UserRepository;
import de.seven.user.domain.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("postgresql")
@RequiredArgsConstructor
public class PostgreSQLRepository implements UserRepository {

    private final EntityManager entityManager;

    @Override
    public User save(User domainUser) {
        UserDTO user = UserDTO.fromDomainUser(domainUser);
        entityManager.persist(user);
        entityManager.flush();
        return user.toDomainUser();
    }

    @Override
    public User findById(String userId) {
        return Optional.ofNullable(entityManager.find(UserDTO.class, userId)).orElse(UserDTO.builder().build()).toDomainUser();
    }

    @Override
    public List<User> findAll() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<UserDTO> query = entityManager.createQuery(jpql, UserDTO.class);
        return query.getResultList().stream().map(UserDTO::toDomainUser).toList();
    }

    @Override
    public void delete(String userId) {
        entityManager.remove(entityManager.find(UserDTO.class, userId));
    }
}
