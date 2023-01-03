package com.bellanger.technical_test.dto.request.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Locale;

public class CountryValidator implements ConstraintValidator<CountryConstraint, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Locale.FRANCE.getISO3Country().equals(value);
    }
}
