package com.store.controller;

import com.store.dto.ProductDto;
import com.store.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getAll() { return productService.findAll(); }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ProductDto create(@Valid @RequestBody ProductDto dto) { return productService.create(dto); }
}
