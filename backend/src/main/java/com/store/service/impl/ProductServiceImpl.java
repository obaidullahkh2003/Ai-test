package com.store.service.impl;

import com.store.dto.ProductDto;
import com.store.entity.Category;
import com.store.entity.Product;
import com.store.exception.NotFoundException;
import com.store.mapper.ProductMapper;
import com.store.repository.CategoryRepository;
import com.store.repository.ProductRepository;
import com.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper mapper;

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ProductDto create(ProductDto dto) {
        Category category = categoryRepository.findById(dto.categoryId()).orElseThrow(() -> new NotFoundException("Category not found"));
        Product product = new Product();
        map(dto, product, category);
        return mapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductDto update(Long id, ProductDto dto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        Category category = categoryRepository.findById(dto.categoryId()).orElseThrow(() -> new NotFoundException("Category not found"));
        map(dto, product, category);
        return mapper.toDto(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    private void map(ProductDto dto, Product product, Category category) {
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setStock(dto.stock());
        product.setCategory(category);
    }
}
