package com.store.controller;

import com.store.dto.ProductDto;
import com.store.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService service;

  @GetMapping
  public List<ProductDto> list() { return service.list(); }

  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  public ProductDto create(@RequestBody @Valid ProductDto dto) { return service.create(dto); }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void delete(@PathVariable Long id) { service.delete(id); }
}
