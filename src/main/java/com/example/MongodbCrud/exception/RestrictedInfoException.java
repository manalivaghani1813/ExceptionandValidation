package com.example.MongodbCrud.exception;

public class RestrictedInfoException extends Exception{
    @Override
    public String getMessage(){
        return "Not Allowed.....";
    }
}
