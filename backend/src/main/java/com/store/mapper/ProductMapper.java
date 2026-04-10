package com.store.mapper;

import com.store.dto.ProductDto;
import com.store.entity.Category;
import com.store.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", source = "category")
    Product toEntity(ProductDto dto, Category category);
}
