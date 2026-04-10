package com.store.service;

import com.store.dto.ProductDto;
import com.store.entity.Product;
import com.store.exception.NotFoundException;
import com.store.mapper.ProductMapper;
import com.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final CategoryService categoryService;

    public ProductService(ProductRepository repository, ProductMapper mapper, CategoryService categoryService) {
        this.repository = repository;
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

    public List<ProductDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public Product getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public ProductDto create(ProductDto dto) {
        Product product = new Product();
        apply(dto, product);
        return mapper.toDto(repository.save(product));
    }

    public ProductDto update(Long id, ProductDto dto) {
        Product product = getById(id);
        apply(dto, product);
        return mapper.toDto(repository.save(product));
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }

    private void apply(ProductDto dto, Product product) {
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setStock(dto.stock());
        product.setCategory(categoryService.getById(dto.categoryId()));
    }
}
