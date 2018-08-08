package com.sao.dentalappointment.appointment.cross_cutting_concerns;

public class ClientException extends RuntimeException {

    public final static String NOT_FOUND = "Client not found";

    public ClientException(String message) {
        super(message);
    }
}
