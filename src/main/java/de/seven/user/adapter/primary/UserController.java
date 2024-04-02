package de.seven.user.adapter.primary;

import de.seven.user.application.service.UserService;
import de.seven.user.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public List<User> getProducts() {
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public User getProducts(@PathVariable String userId) {
        return userService.findUserById(userId);
    }

    @PostMapping("/")
    public User saveProducts(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteProductById(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
