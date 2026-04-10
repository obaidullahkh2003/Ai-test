package com.store.service;

import com.store.entity.*;
import com.store.exception.NotFoundException;
import com.store.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
  private final CartItemRepository cartRepository;
  private final ProductRepository productRepository;
  private final OrderRepository orderRepository;

  public List<CartItem> items(String customerId) { return cartRepository.findByCustomerId(customerId); }

  public CartItem addItem(String customerId, Long productId, Integer quantity) {
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new NotFoundException("Product not found: " + productId));
    return cartRepository.save(CartItem.builder().customerId(customerId).product(product).quantity(quantity).build());
  }

  @Transactional
  public CustomerOrder checkout(String customerId) {
    List<CartItem> items = cartRepository.findByCustomerId(customerId);
    BigDecimal total = items.stream().map(i -> i.getProduct().getPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    CustomerOrder order = CustomerOrder.builder().customerId(customerId).createdAt(OffsetDateTime.now()).total(total).build();
    for (CartItem i : items) {
      order.getItems().add(OrderItem.builder().order(order).product(i.getProduct()).quantity(i.getQuantity())
          .unitPrice(i.getProduct().getPrice()).build());
    }
    CustomerOrder saved = orderRepository.save(order);
    cartRepository.deleteAll(items);
    return saved;
  }
}
