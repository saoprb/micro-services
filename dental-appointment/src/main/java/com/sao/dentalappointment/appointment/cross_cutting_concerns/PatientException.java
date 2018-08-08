package com.sao.dentalappointment.appointment.cross_cutting_concerns;

public class PatientException extends RuntimeException {

    public final static String NOT_FOUND = "Patient not found";

    public PatientException(String message) {
        super(message);
    }
}
