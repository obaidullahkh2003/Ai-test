package com.store.service;

import com.store.dto.OrderDto;
import com.store.entity.CartItem;
import com.store.entity.CustomerOrder;
import com.store.entity.OrderItem;
import com.store.mapper.OrderMapper;
import com.store.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, CartService cartService, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.orderMapper = orderMapper;
    }

    @Transactional
    public OrderDto checkout(String customerId) {
        List<CartItem> cartItems = cartService.getCartEntities(customerId);
        CustomerOrder order = new CustomerOrder();
        order.setCustomerId(customerId);

        BigDecimal total = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems) {
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(cartItem.getProduct());
            item.setQuantity(cartItem.getQuantity());
            item.setUnitPrice(cartItem.getProduct().getPrice());
            order.getItems().add(item);
            total = total.add(cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())));
        }
        order.setTotal(total);
        CustomerOrder saved = orderRepository.save(order);
        cartService.clearCart(customerId);
        return orderMapper.toDto(saved);
    }

    public List<OrderDto> myOrders(String customerId) {
        return orderMapper.toDtos(orderRepository.findByCustomerId(customerId));
    }
}
