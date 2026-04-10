package com.store.service;

import com.store.domain.CustomerOrder;
import com.store.domain.OrderItem;
import com.store.dto.OrderDto;
import com.store.mapper.StoreMapper;
import com.store.repository.OrderRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final StoreMapper mapper;

    public OrderService(OrderRepository orderRepository, CartService cartService, StoreMapper mapper) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.mapper = mapper;
    }

    @Transactional
    public OrderDto checkout(String customerId) {
        CustomerOrder order = new CustomerOrder();
        order.setCustomerId(customerId);

        List<OrderItem> items = cartService.getRaw(customerId).stream().map(ci -> {
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(ci.getProduct());
            item.setQuantity(ci.getQuantity());
            item.setUnitPrice(ci.getProduct().getPrice());
            return item;
        }).toList();

        order.setItems(items);
        CustomerOrder saved = orderRepository.save(order);
        cartService.clear(customerId);
        return mapper.toDto(saved);
    }

    public List<OrderDto> getOrders(String customerId) {
        return orderRepository.findByCustomerId(customerId).stream().map(mapper::toDto).toList();
    }
}
