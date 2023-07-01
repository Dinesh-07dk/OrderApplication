package com.order.service;

import com.order.dto.OrderRequestDto;
import com.order.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {

	String insertOrder(OrderRequestDto  orderRequestDto );

	List<OrderResponseDto> getOrderDetails();

	String updateOrder(String orderId, OrderRequestDto orderRequestDto);

	String deleteOrder(String orderId);

}
