package com.bci.users.utils;

public enum Constants {
    ERROR001("Duplicate name error."),
    ERROR002("Duplicate email error."),
    DEFAULT_ERROR("Unexpected error, contact your administrator.");

    private final String value;

    Constants(String value) {
        this.value = value;
    }
    public String value() {
        return this.value;
    }

}