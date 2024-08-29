package com.product.annotation.impl;

import com.product.constants.Constant;
import com.product.request.ProductRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class ProductRequestValidator  implements ConstraintValidator<ValidateProductRequest, ProductRequest> {
    boolean isValid = true;

    @Override
    public boolean isValid(ProductRequest request, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        isValid = true;
        validate(request, context);
        return isValid;
    }


    private void validate(ProductRequest request, ConstraintValidatorContext context) {
        isNameValid(request.name(), context);
        if (isValid) isPriceValid(request.price(), context);
        if (isValid) isQuantityValid(request.quantity(), context);
    }

    private void isNameValid(String name, ConstraintValidatorContext context) {
        if (!StringUtils.hasText(name)) error(context, Constant.NAME_ERROR_MESSAGE);
    }

    private void isPriceValid(Double price, ConstraintValidatorContext context) {
        if(Objects.isNull(price) || price.equals( 0.0)){
            error(context, Constant.PRICE_INVALID);
            isValid = false;
        }
    }

    private void isQuantityValid(Double quantity, ConstraintValidatorContext context) {
        if(Objects.isNull(quantity) || quantity.equals( 0.0)){
            error(context, Constant.QUANTITY_INVALID);
            isValid = false;
        }
    }

    private void error(ConstraintValidatorContext context, String error) {
        context.buildConstraintViolationWithTemplate(error).addConstraintViolation();
        isValid = false;
    }
}
