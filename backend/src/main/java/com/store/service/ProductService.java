package com.store.service;

import com.store.dto.ProductDto;
import com.store.entity.Category;
import com.store.entity.Product;
import com.store.exception.ResourceNotFoundException;
import com.store.mapper.ProductMapper;
import com.store.repository.CategoryRepository;
import com.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    public ProductDto create(ProductDto dto) {
        Category category = categoryRepository.findById(dto.categoryId())
            .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        Product saved = productRepository.save(productMapper.toEntity(dto, category));
        return productMapper.toDto(saved);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
