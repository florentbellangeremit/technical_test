package com.bellanger.technical_test.dto.request.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = CountryValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CountryConstraint {
    String message() default "Country must be FRA";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
