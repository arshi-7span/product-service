package com.product.response;

public record BaseResponse<T>(Integer resultCode, String resultMessage, T data) {

    public BaseResponse(Integer resultCode, String resultMessage) {
        this(resultCode, resultMessage, null);
    }

    public BaseResponse(Integer resultCode, String resultMessage, T data) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.data = data;
    }
}