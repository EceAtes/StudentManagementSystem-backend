package com.testProject.ws.configuration;

import com.testProject.ws.user.User;
import com.testProject.ws.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User inDB = ur.findByUsername(username);

        if(inDB == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new UserInfo(inDB);
    }
}
