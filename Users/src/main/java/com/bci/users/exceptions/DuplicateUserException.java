package com.bci.users.exceptions;



public class DuplicateUserException extends Exception{

    public DuplicateUserException() {
        super("Usuario duplicado");
    }
}
