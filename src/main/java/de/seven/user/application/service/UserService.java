package de.seven.user.application.service;

import de.seven.user.application.adapter.secondary.UserRepository;
import de.seven.user.domain.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(String userId){
        userRepository.delete(userId);
    }

    public User findUserById(String userId){
        return userRepository.findById(userId);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public List<User> findAllHosts(){
        return userRepository.findAll().stream().filter(User::isAHost).toList();
    }
}