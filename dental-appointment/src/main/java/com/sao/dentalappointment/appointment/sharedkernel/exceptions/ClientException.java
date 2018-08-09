package com.sao.dentalappointment.appointment.sharedkernel.exceptions;

public class ClientException extends RuntimeException {

    public final static String NOT_FOUND = "Client '%s' not found";

    public ClientException(String message, String... params) {
        super(String.format(message, params));
    }
}
