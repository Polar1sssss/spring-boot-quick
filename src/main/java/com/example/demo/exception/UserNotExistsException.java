package com.example.demo.exception;

/**
 * @author hujtb
 * @create on 2018-10-26-16:27
 */
public class UserNotExistsException extends RuntimeException{
    public UserNotExistsException() {
        super("user not exists");
    }
}
