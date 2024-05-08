package de.seven.user.application.adapter.secondary;

import de.seven.user.domain.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    User findById(String userId);

    List<User> findAll();

    void delete(String userId);
}
