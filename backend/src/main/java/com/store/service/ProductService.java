package com.store.service;

import com.store.dto.ProductDto;
import com.store.entity.Product;
import com.store.exception.NotFoundException;
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
  private final ProductMapper mapper;

  public List<ProductDto> list() { return productRepository.findAll().stream().map(mapper::toDto).toList(); }

  public ProductDto create(ProductDto dto) {
    Product product = mapper.toEntity(dto);
    product.setCategory(categoryRepository.findById(dto.categoryId())
        .orElseThrow(() -> new NotFoundException("Category not found: " + dto.categoryId())));
    return mapper.toDto(productRepository.save(product));
  }

  public void delete(Long id) { productRepository.deleteById(id); }
}
