package com.sao.dentalappointment.appointment.domain.valueobject;

import com.sao.dentalappointment.appointment.sharedkernel.exceptions.EmailException;
import com.sao.dentalappointment.appointment.domain.interfaces.IValueObject;
import lombok.Value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Value
public class Email implements IValueObject {

    private final String email;
    private final Pattern pattern;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public Email(String email) {
        this.email = email;
        pattern = Pattern.compile(EMAIL_PATTERN);
        validate();
    }

    private void validate() {
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new EmailException(EmailException.INVALID_EMAIL);
        }
    }
}
