package com.order.service;

import com.order.repository.OrderRepository;
import com.order.dto.OrderRequestDto;
import com.order.dto.OrderResponseDto;
import com.order.mapper.OrderMapper;
import com.order.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class OrderServiceImp implements OrderService {
	private final OrderMapper orderMapper;

	private final OrderRepository orderRepository;

	@Autowired
	public OrderServiceImp(OrderMapper orderMapper, OrderRepository orderRepository) {
		this.orderMapper = orderMapper;
		this.orderRepository = orderRepository;
	}

	@Override
	public String insertOrder(OrderRequestDto orderRequestDto) {
		Order savedOrder = orderRepository.save(orderMapper.map(orderRequestDto));
		log.info("Order inserted successfully orderId: {}",savedOrder.getOrderId());

		return "Success, orderId:  " + savedOrder.getOrderId();
	}

	@Override
	public List<OrderResponseDto> getOrderDetails() {

		return orderMapper.map(orderRepository.findAll());
	}

	@Override
	public String updateOrder(String orderId, OrderRequestDto orderRequestDto) {
		Order order = orderRepository.findByOrderId(orderId);
		if(Objects.isNull(order)){
			return "Invalid orderId";
		}
		order.setDescription(orderRequestDto.getDescription());
		order.setQuantity(orderRequestDto.getQuantity());
		orderRepository.save(order);
		log.info("Order updated successfully orderId: {}",orderId);

		return "Success";
	}

	@Override
	public String deleteOrder(String orderId) {
		Order order = orderRepository.findByOrderId(orderId);
		if(Objects.isNull(order)){
			return "Invalid orderId";
		}
		orderRepository.delete(order);
		log.info("Order deleted successfully orderId: {}",orderId);

		return "Success";
	}
}
