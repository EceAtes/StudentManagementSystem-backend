package com.testProject.ws.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.testProject.ws.shared.View;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    @JsonView(View.Base.class)
    private int status;
    @JsonView(View.Base.class)
    private String message;
    @JsonView(View.Base.class)
    private String path;
    @JsonView(View.Base.class)
    private long timestamp = new Date().getTime();
    private Map<String, String> validationErr;

    public ApiError(int status, String message, String path){
        this.message = message + "!";
        this.path = path;
        this.status = status;
    }
 }
