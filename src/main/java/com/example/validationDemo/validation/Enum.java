package com.example.validationDemo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface Enum {

    Class<? extends java.lang.Enum<?>>  enumClass();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String message() default "envalid Enum Value";

}

