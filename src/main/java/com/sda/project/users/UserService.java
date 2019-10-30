package com.sda.project.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service("userService")
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public void save(User user) {

        String oldPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(oldPassword));
        userRepository.save(user);
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
    public Optional<User>  getByEmail (String email){return userRepository.findByEmail(email); }

    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> byEmail = userRepository.findByEmail(email);
//        User user;
//        if(byEmail.isPresent()) {
//            user=byEmail.get();
//        }else {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
//    }

    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        Optional<User> byFirstName = userRepository.findByEmail(firstName);
        User user;
        if(byFirstName.isPresent()) {
            user=byFirstName.get();
        }else {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getFirstName(), user.getPassword(), getAuthority(user));
    }

    private Collection<? extends GrantedAuthority> getAuthority(User user) {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + "USER")); //TODO add role field to user; can be user, admin etc.
    }
}




