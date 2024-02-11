package de.seven.user.application.adapter.secondary;

import de.seven.user.domain.model.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {

    User insertUser(Map<String, String> user);

    User updateUser(User user);

    User findUserById(Integer userId);

    List<User> findUser(Map<String, String> user);

    void deleteUser(User user);

    void deleteUser(Integer userId);
}
