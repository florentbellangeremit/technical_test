package com.bellanger.technical_test.dto.request.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.sql.Timestamp;
import java.util.Calendar;

public class BirthdateValidator implements ConstraintValidator<BirthdateConstraint, Timestamp> {

    @Override
    public boolean isValid(Timestamp value, ConstraintValidatorContext context) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());
        cal.add(Calendar.YEAR, -18);
        timestamp = new Timestamp(cal.getTime().getTime());
        return value.before(timestamp);
    }
}