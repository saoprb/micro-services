package com.sao.dentalappointment.appointment.cross_cutting_concerns;

public class DateTimeRangeException extends RuntimeException {

    public static final String NOT_SAME_DAY = "Start and end time must be on same day";
    public static final String END_BEFORE_START = "End time must be after start time";

    public DateTimeRangeException(String message) {
        super(message);
    }
}
