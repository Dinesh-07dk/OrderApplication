package com.order.controller;

import com.order.dto.OrderRequestDto;
import com.order.dto.OrderResponseDto;
import com.order.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OrderController {
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/order")
	public List<OrderResponseDto> getOrders(){
		return orderService.getOrderDetails();
	}

	@PostMapping("/order")
	public String insertOrder(@RequestBody OrderRequestDto  orderRequestDto){
		return orderService.insertOrder(orderRequestDto);
	}

	@PutMapping("/order/{orderId}")
	public String updateOrders(@PathVariable String orderId, @RequestBody OrderRequestDto orderRequestDto){
		return orderService.updateOrder(orderId,orderRequestDto);
	}

	@DeleteMapping("/order/{orderId}")
	public String deleteOrder(@PathVariable String orderId){
		return orderService.deleteOrder(orderId);
	}

}
