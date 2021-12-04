package com.bci.users.exceptions;



public class DuplicateEmailException extends Exception {

    public DuplicateEmailException() {
        super("Email duplicado");
    }
}
