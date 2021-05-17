package com.epam.locators.exeptions;

public abstract class BaseExceptions extends Exception{
    private String message;

    public BaseExceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
