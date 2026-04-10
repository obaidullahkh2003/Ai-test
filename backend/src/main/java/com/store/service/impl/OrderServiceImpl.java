package com.store.service.impl;

import com.store.dto.OrderDto;
import com.store.entity.CartItem;
import com.store.entity.CustomerOrder;
import com.store.entity.OrderItem;
import com.store.repository.CartItemRepository;
import com.store.repository.OrderRepository;
import com.store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;

    @Override
    public OrderDto checkout(String username) {
        List<CartItem> cartItems = cartItemRepository.findByUsername(username);
        CustomerOrder order = new CustomerOrder();
        order.setUsername(username);
        order.setTotalAmount(cartItems.stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add));

        for (CartItem ci : cartItems) {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setProduct(ci.getProduct());
            oi.setQuantity(ci.getQuantity());
            oi.setUnitPrice(ci.getProduct().getPrice());
            order.getItems().add(oi);
        }
        CustomerOrder saved = orderRepository.save(order);
        cartItemRepository.deleteByUsername(username);
        return toDto(saved);
    }

    @Override
    public List<OrderDto> myOrders(String username) {
        return orderRepository.findByUsername(username).stream().map(this::toDto).toList();
    }

    private OrderDto toDto(CustomerOrder order) {
        return new OrderDto(order.getId(), order.getTotalAmount(), order.getCreatedAt(),
                order.getItems().stream()
                        .map(i -> new OrderDto.OrderLineDto(i.getProduct().getId(), i.getProduct().getName(), i.getQuantity(), i.getUnitPrice()))
                        .toList());
    }
}
