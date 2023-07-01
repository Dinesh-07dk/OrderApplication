package com.order.mapper;

import com.order.dto.OrderRequestDto;
import com.order.dto.OrderResponseDto;
import com.order.entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class OrderMapper {

    public Order map(OrderRequestDto orderRequestDto){
        Order order=new Order();
        order.setOrderId(UUID.randomUUID().toString());

        order.setDescription(orderRequestDto.getDescription());
        order.setQuantity(orderRequestDto.getQuantity());

        return  order;
    }

    public List<OrderResponseDto> map(List<Order> orders) {
        List<OrderResponseDto> orderResponseDtoList=new ArrayList<>();

        for(Order order:orders) {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setOrderId(order.getOrderId());
            orderResponseDto.setQuantity(order.getQuantity());
            orderResponseDto.setDate(order.getDate().toString());
            orderResponseDto.setDescription(order.getDescription());

            orderResponseDtoList.add(orderResponseDto);
        }
        return orderResponseDtoList;
    }

}
