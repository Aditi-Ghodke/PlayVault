package org.playvault.custom_exceptions;

public class ApiResponse extends RuntimeException{
    public ApiResponse(String message){
        super(message);
    }
}
