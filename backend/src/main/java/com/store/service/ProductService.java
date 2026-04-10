package com.store.service;

import com.store.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto create(ProductDto dto);
    ProductDto update(Long id, ProductDto dto);
    void delete(Long id);
}
