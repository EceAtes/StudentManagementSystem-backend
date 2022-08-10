package com.testProject.ws.error;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class ApiError {
    private int status;
    private String message, path;
    private long timestamp = new Date().getTime();
    private Map<String, String> validationErr;

    public ApiError(int status, String message, String path){
        this.message = message;
        this.path = path;
        this.status = status;
    }
 }
