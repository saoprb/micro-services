package com.sao.dentalappointment.appointment.cross_cutting_concerns;

public class EmailException extends RuntimeException {

    public static final String INVALID_EMAIL = "Invalid email format";

    public EmailException(String message) {
        super(message);
    }
}
