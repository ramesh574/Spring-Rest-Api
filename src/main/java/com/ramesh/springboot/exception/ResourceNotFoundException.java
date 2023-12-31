package com.ramesh.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private int  fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
      super(String.format("%s is not found %s :'%s'",resourceName,fieldName,fieldValue));
      this.resourceName=resourceName;
      this.fieldName=fieldName;
      this.fieldValue=fieldValue;
    }
}
