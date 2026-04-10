package com.store.service;

import com.store.dto.ProductDto;
import com.store.entity.Category;
import com.store.mapper.ProductMapper;
import com.store.repository.CategoryRepository;
import com.store.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock ProductRepository productRepository;
    @Mock CategoryRepository categoryRepository;
    @Mock ProductMapper productMapper;

    @InjectMocks ProductService productService;

    @Test
    void createShouldResolveCategory() {
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(new Category()));
        productService.create(new ProductDto(null, "CPU", java.math.BigDecimal.TEN, 5, 1L));
    }
}
