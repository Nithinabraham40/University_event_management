package com.tutorial.university.custumvalidation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.tutorial.university.customvalidatorImpl.CapitalizedValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.ElementType;

import java.lang.annotation.RetentionPolicy;
@Constraint(validatedBy = {CapitalizedValidator.class})
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface Capitalized {
    String message() default "Field should start with a capital letter";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
