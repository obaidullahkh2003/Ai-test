package com.store.service;

import com.store.domain.Product;
import com.store.dto.ProductDto;
import com.store.exception.NotFoundException;
import com.store.mapper.StoreMapper;
import com.store.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final StoreMapper mapper;

    public ProductService(ProductRepository productRepository, CategoryService categoryService, StoreMapper mapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(mapper::toDto).toList();
    }

    public ProductDto create(ProductDto dto) {
        Product p = new Product();
        p.setName(dto.name());
        p.setPrice(dto.price());
        p.setStock(dto.stock());
        p.setCategory(categoryService.getRef(dto.categoryId()));
        return mapper.toDto(productRepository.save(p));
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }
}
