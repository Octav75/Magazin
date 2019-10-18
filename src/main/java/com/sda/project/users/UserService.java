package com.sda.project.users;

import com.sda.project.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    public void save(User user) {
        userRepository.save(user);
    }
}




