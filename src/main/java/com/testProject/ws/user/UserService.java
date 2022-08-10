package com.testProject.ws.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRep;

    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRep) {
        this.userRep = userRep;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void save(User user) {
        String encoded = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encoded);
        userRep.save(user);
    }
}
