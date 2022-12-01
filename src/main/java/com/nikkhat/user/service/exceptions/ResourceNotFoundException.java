package com.nikkhat.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    //Extra properties that you want to manage

    public ResourceNotFoundException(){
        super("Resource Not Found On Server !!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
