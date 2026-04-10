package com.store.service;

import com.store.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto checkout(String username);
    List<OrderDto> myOrders(String username);
}
