package com.store.service;

import com.store.dto.ProductDto;
import com.store.entity.Category;
import com.store.mapper.ProductMapper;
import com.store.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock ProductRepository productRepository;
    @Mock ProductMapper productMapper;
    @Mock CategoryService categoryService;
    @InjectMocks ProductService productService;

    @Test
    void createShouldPersistProduct() {
        ProductDto dto = new ProductDto(null, "GPU", "desc", BigDecimal.TEN, 5, 1L);
        when(categoryService.getById(1L)).thenReturn(new Category());

        productService.create(dto);

        verify(productRepository).save(org.mockito.ArgumentMatchers.any());
    }
}
