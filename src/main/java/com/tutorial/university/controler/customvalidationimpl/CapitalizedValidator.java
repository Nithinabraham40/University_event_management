package com.tutorial.university.controler.customvalidationimpl;

import com.tutorial.university.custumvalidation.Capitalized;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CapitalizedValidator implements ConstraintValidator<Capitalized, String> {
    @Override
    public void initialize(Capitalized capitalized) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        return Character.isUpperCase(value.charAt(0));
    }
}