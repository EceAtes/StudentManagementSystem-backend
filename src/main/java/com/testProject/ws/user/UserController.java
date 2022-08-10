package com.testProject.ws.user;

import com.testProject.ws.error.ApiError;
import com.testProject.ws.shared.ReturnMessage;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userSer;

    @PostMapping("/api/1.0/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        userSer.save(user);
        return ResponseEntity.ok(new ReturnMessage("User created"));

    }

    public ApiError validationExceptions(MethodArgumentNotValidException exp){
        ApiError err = new ApiError(400, "Validation Error", "/api/1.0/users");
        Map<String, String> validationErr = new HashMap<>();

        for(FieldError fe : exp.getBindingResult().getFieldErrors()){
            validationErr.put(fe.getField(), fe.getDefaultMessage());
        }
        err.setValidationErr(validationErr);
        return err;
    }

}
