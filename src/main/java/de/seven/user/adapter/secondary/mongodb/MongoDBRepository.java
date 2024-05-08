package de.seven.user.adapter.secondary.mongodb;

import de.seven.user.adapter.secondary.mongodb.model.UserDTO;
import de.seven.user.application.adapter.secondary.UserRepository;
import de.seven.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("mongodb")
@RequiredArgsConstructor
public class MongoDBRepository implements UserRepository{

    private final UserMongoRepository userMongoRepository;

    @Override
    public User save(User domainUser) {
        UserDTO user = UserDTO.fromDomainUser(domainUser);
        userMongoRepository.save(user);
        return user.toDomainUser();
    }

    @Override
    public User findById(String userId) {
        return userMongoRepository.findById(userId).orElse(UserDTO.builder().build()).toDomainUser();
    }

    @Override
    public List<User> findAll() {
        return userMongoRepository.findAll().stream().map(UserDTO::toDomainUser).toList();
    }

    @Override
    public void delete(String userId) {
        userMongoRepository.deleteById(userId);
    }
}
