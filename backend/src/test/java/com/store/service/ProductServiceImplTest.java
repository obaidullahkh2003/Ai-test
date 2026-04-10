package com.store.service;

import com.store.dto.ProductDto;
import com.store.entity.Category;
import com.store.entity.Product;
import com.store.mapper.ProductMapper;
import com.store.repository.CategoryRepository;
import com.store.repository.ProductRepository;
import com.store.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock ProductRepository productRepository;
    @Mock CategoryRepository categoryRepository;
    @Mock ProductMapper mapper;
    @InjectMocks ProductServiceImpl service;

    @Test
    void createProduct() {
        ProductDto in = new ProductDto(null, "RTX 5090", "GPU", BigDecimal.TEN, 2, 1L);
        Category category = new Category();
        category.setId(1L);
        Product product = new Product();
        product.setId(5L);

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(productRepository.save(any(Product.class))).thenReturn(product);
        when(mapper.toDto(product)).thenReturn(new ProductDto(5L, "RTX 5090", "GPU", BigDecimal.TEN, 2, 1L));

        ProductDto out = service.create(in);
        assertEquals(5L, out.id());
    }
}
