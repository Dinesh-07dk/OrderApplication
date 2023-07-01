package com.order.dto;

import lombok.Data;

@Data
public class OrderResponseDto {
    private String orderId;
    private int quantity;
    private String description;
    private String date;
}
