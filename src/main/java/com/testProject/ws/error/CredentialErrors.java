package com.testProject.ws.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class CredentialErrors implements ErrorController {
    @Autowired
    ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    ApiError handleError(WebRequest wr){
        Map<String, Object> attrs = this.errorAttributes.getErrorAttributes(wr, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS));
        String message = (String) attrs.get("message") ;
        String path = (String) attrs.get("path");
        int status = (Integer) attrs.get("status");
        ApiError error = new ApiError(status, message, path);

        if(attrs.containsKey("errors")){
            @SuppressWarnings("unchecked")
            List<FieldError> fieldErrors = (List<FieldError>) attrs.get("errors");
            Map<String, String> validationErrors = new HashMap<>();
            for(FieldError fe: fieldErrors){
                validationErrors.put(fe.getField(), fe.getDefaultMessage());
            }
            error.setValidationErr(validationErrors);
        }
        return error;
    }

    public String getErrorPath(){
        return "/error";
    }
}
