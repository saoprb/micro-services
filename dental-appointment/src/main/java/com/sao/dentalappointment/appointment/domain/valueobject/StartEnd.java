package com.sao.dentalappointment.appointment.domain.valueobject;

import com.sao.dentalappointment.appointment.cross_cutting_concerns.DateTimeRangeException;
import com.sao.dentalappointment.appointment.domain.interfaces.IValueObject;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class StartEnd implements IValueObject {
    private LocalDateTime start;
    private LocalDateTime end;

    public StartEnd(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
        validate();
    }

    public void validate() {
        if (end.isBefore(start)) {
            throw new DateTimeRangeException(DateTimeRangeException.END_BEFORE_START);
        }
        if (start.getDayOfMonth() != end.getDayOfMonth()) {
            throw new DateTimeRangeException(DateTimeRangeException.NOT_SAME_DAY);
        }
    }
}
