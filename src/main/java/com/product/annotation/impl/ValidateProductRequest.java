package com.product.annotation.impl;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductRequestValidator.class)
public @interface ValidateProductRequest {
    String message() default "Default Message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
