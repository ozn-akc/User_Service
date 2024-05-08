package de.seven.user.adapter.secondary.mongodb;

import de.seven.user.adapter.secondary.mongodb.model.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<UserDTO, String> {
}
