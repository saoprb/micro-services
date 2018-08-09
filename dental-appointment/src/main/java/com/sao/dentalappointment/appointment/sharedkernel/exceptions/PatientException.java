package com.sao.dentalappointment.appointment.sharedkernel.exceptions;

public class PatientException extends RuntimeException {

    public final static String NOT_FOUND = "Patient '%s' not found";

    public PatientException(String message, String... params) {
        super(String.format(message, params));
    }
}
