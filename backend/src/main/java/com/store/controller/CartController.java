package com.store.controller;

import com.store.entity.CartItem;
import com.store.entity.CustomerOrder;
import com.store.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
  private final CartService service;

  @GetMapping
  public List<CartItem> items(@AuthenticationPrincipal Jwt jwt) { return service.items(jwt.getSubject()); }

  @PostMapping("/items")
  public CartItem add(@AuthenticationPrincipal Jwt jwt, @RequestBody Map<String, String> body) {
    return service.addItem(jwt.getSubject(), Long.parseLong(body.get("productId")), Integer.parseInt(body.get("quantity")));
  }

  @PostMapping("/checkout")
  public CustomerOrder checkout(@AuthenticationPrincipal Jwt jwt) { return service.checkout(jwt.getSubject()); }
}
