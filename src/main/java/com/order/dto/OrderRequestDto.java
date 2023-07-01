package com.order.dto;

import lombok.Data;

@Data
public class OrderRequestDto {
    private int quantity;
    private String description;
}
