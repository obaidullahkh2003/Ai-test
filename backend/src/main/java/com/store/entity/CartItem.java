package com.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "cart_items")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CartItem {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false) private String customerId;
  @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "product_id")
  private Product product;
  @Column(nullable = false) private Integer quantity;
}
