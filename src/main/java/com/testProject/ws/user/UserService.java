package com.testProject.ws.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRep;

    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRep, PasswordEncoder pe) {
        this.userRep = userRep;
        this.passwordEncoder = pe;
    }

    public void save(User user) {
        String encoded = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encoded);
        userRep.save(user);
    }

    public Page<User> getUsers(Pageable page) {
        return userRep.findAll(page);
       // return userRep.findAll();
    }
}
