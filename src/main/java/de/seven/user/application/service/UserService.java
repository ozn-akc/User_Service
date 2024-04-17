package de.seven.user.application.service;

import de.seven.user.application.adapter.secondary.ProductClient;
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
    private final ProductClient productClient;

    @Autowired
    public UserService(UserRepository userRepository, ProductClient productClient){
        this.userRepository = userRepository;
        this.productClient = productClient;
    }

    public User saveUser(User user){
        User result = userRepository.save(user);
        if(result.isAHost()){
            productClient.saveHost(result.getUserId());
        }
        return result;
    }

    public void deleteUser(String userId){
        User user = findUserById(userId);
        if(user.isAHost()){
            productClient.deleteHost(userId);
        }
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