package com.product.exception;

import com.product.constants.Constant;
import com.product.enums.ResultCode;
import com.product.response.BaseResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = ProductException.class)
    public BaseResponse<Object> customExceptionHandler(ProductException exception) {
        return new BaseResponse<>(exception.getErrorCode(), exception.getErrorMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BaseResponse<Object> methodArgumentNotValidExceptionHandler(
            MethodArgumentNotValidException exception) {
        List<String> errorMessages =
                exception.getBindingResult().getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList();
        String errorMessage = errorMessages.isEmpty() ? Constant.ERROR_OCCURRED : errorMessages.get(0);
        return new BaseResponse<>(ResultCode.BAD_REQUEST.getValue(), errorMessage);
    }

//    @ExceptionHandler(value = ConstraintViolationException.class)
//    public BaseResponse<Object> constrainViolationExceptionHandler(
//            ConstraintViolationException exception) {
//        List<String> errorMessages =
//                exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();
//        return new BaseResponse<>(
//                ResultCode.CONSTRAINT_VIOLATION.getValue(),
//                ResultCode.CONSTRAINT_VIOLATION.getName(),
//                errorMessages);
//    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public BaseResponse<Object> illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        return new BaseResponse<>(
                ResultCode.BAD_REQUEST.getValue(),
                ResultCode.BAD_REQUEST.getName(),
                exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<Object> handleException(Exception exception) {
        exception.printStackTrace();
        return new BaseResponse<>(
                ResultCode.SOMETHING_WENT_WRONG.getValue(), ResultCode.SOMETHING_WENT_WRONG.getName());
    }
}
