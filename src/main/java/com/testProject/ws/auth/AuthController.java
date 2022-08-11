package com.testProject.ws.auth;

import com.fasterxml.jackson.annotation.JsonView;
import com.testProject.ws.configuration.UserInfo;
import com.testProject.ws.error.ApiError;
import com.testProject.ws.shared.View;
import com.testProject.ws.user.User;
import com.testProject.ws.user.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import org.slf4j.Logger;

@RestController
public class AuthController {
    @Autowired
    UserRepository ur;

    //PasswordEncoder pe = new BCryptPasswordEncoder();
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    @PostMapping("/api/1.0/auth")
    @JsonView(View.Base.class)
    ResponseEntity<?> authenticationHandler(@RequestHeader(name="Authorization") String authorization){
       /* BasicErrorController
        if(authorization == null){
            ApiError err = new ApiError(401, "Unauthorized", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
        }*/
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userInfo.getUsername();
        /*String encoded = authorization.split("Basic ")[1];
        String decoded = new String(Base64.getDecoder().decode(encoded));
        String[] parts = decoded.split(":");
        System.out.println("decoded:" + encoded);

        String username = parts[0];
        String password = parts[1];*/
        log.info(username);
        //log.info(password);
        User inDB = ur.findByUsername(username);
        /*String codedPassword = inDB.getPassword();

        if (inDB == null){
            ApiError err = new ApiError(401, "Unauthorized", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
        }

        if(!pe.matches(password, codedPassword)){
            ApiError err = new ApiError(401, "Unauthorized", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
        }*/

        return ResponseEntity.ok(inDB);
    }

    /*@ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    ApiError handleBadCredentialsException(){
        ApiError err = new ApiError(401, "Unauthorized", "/api/1.0/auth");
        return err;
    }
*/
}
