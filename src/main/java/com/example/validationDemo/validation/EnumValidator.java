package com.example.validationDemo.validation;

import org.apache.logging.log4j.util.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class EnumValidator implements ConstraintValidator<Enum, String> {

    private Class <? extends java.lang.Enum> enumClass;

    @Override
    public void initialize(Enum constraintAnnotation) {
        enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(Strings.isBlank(value)) {
            return true;
        }

        java.lang.Enum[] enumValues = enumClass.getEnumConstants();

        boolean match = Arrays.stream(enumValues).anyMatch(enumValue -> value.equals(enumValue.name()));

        return match;
    }
}
