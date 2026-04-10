package com.store.controller;

import com.store.dto.ProductDto;
import com.store.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> list() { return productService.findAll(); }

    @PostMapping
    public ProductDto create(@Valid @RequestBody ProductDto dto) { return productService.create(dto); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { productService.delete(id); }
}
