package com.sao.dentalappointment.appointment.sharedkernel.exceptions;

public class DateTimeRangeException extends RuntimeException {

    public static final String NOT_SAME_DAY = "Start time '%s' and end time '%s' must be on same day";
    public static final String END_BEFORE_START = "End time '%s' must be after start time '%s'";

    public DateTimeRangeException(String message, String... params) {
        super(String.format(message, params));
    }
}
