package de.seven.user.application.service;

import de.seven.user.application.adapter.secondary.UserRepository;
import de.seven.user.domain.model.User;

import java.util.List;
import java.util.Map;

public class UserService {

    //TODO Hier den Adapter einsetzen
    private UserRepository userRepository;

    public UserService(){
        this.userRepository = userRepository;
    }

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User insertUser(Map<String, String> user){
        return userRepository.insertUser(user);
    }

    public User updateUser(User user){
        return userRepository.updateUser(user);
    }

    public void deleteUser(User user){
        userRepository.deleteUser(user);
    }

    public void deleteUser(Integer userId){
        userRepository.deleteUser(userId);
    }

    public User findUserById(Integer userId){
        return userRepository.findUserById(userId);
    }

    public List<User> findUser(Map<String, String> user){
        return userRepository.findUser(user);
    }
}