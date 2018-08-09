package com.sao.dentalappointment.appointment.sharedkernel.exceptions;

public class EmailException extends RuntimeException {

    public static final String INVALID_EMAIL = "Invalid email format, '%s'";

    public EmailException(String message, String... params) {
        super(String.format(message, params));
    }
}
