package com.order.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

}
