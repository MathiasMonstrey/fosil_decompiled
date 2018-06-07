package com.fossil.wearables.fsl.fitness.exception;

public class InvalidTimezoneIDException extends Exception {
    public InvalidTimezoneIDException(String str) {
        super("Invalid timezone id: " + str);
    }
}
