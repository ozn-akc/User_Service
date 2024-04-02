package de.seven.user.adapter.secondary.postgresql;

import de.seven.user.adapter.secondary.postgresql.model.User;
import de.seven.user.application.adapter.secondary.UserRepository;
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
    public de.seven.user.domain.model.User save(de.seven.user.domain.model.User domainUser) {
        User user = User.fromDomainUser(domainUser);
        entityManager.persist(user);
        entityManager.flush();
        return user.toDomainUser();
    }

    @Override
    public de.seven.user.domain.model.User findById(String userId) {
        return Optional.ofNullable(entityManager.find(User.class, userId)).orElse(User.builder().build()).toDomainUser();
    }

    @Override
    public List<de.seven.user.domain.model.User> findAll() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList().stream().map(User::toDomainUser).toList();
    }

    @Override
    public void delete(String userId) {
        entityManager.remove(entityManager.find(User.class, userId));
    }
}
