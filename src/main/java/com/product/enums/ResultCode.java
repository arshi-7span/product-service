package com.product.enums;

import lombok.Getter;

@Getter
public enum ResultCode {
    // One Thousand series is used for common result code
    SUCCESS(1001, "Success"),
    FAILED(1002, "Failed"),
    BAD_REQUEST(1003, "Bad Request"),
    INVALID_OPERATION(1005, "Invalid Operation"),
    SOMETHING_WENT_WRONG(1500, "Something went wrong");

    private final int value;
    private final String name;

    ResultCode(int value, String name) {
        this.value = value;
        this.name = name;
    }

}
