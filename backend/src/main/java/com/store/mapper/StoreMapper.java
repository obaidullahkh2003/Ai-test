package com.store.mapper;

import com.store.domain.CartItem;
import com.store.domain.Category;
import com.store.domain.CustomerOrder;
import com.store.domain.OrderItem;
import com.store.domain.Product;
import com.store.dto.CategoryDto;
import com.store.dto.OrderDto;
import com.store.dto.OrderItemDto;
import com.store.dto.ProductDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    CategoryDto toDto(Category category);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.name")
    OrderItemDto toDto(OrderItem item);

    List<OrderItemDto> toItemDtos(List<OrderItem> items);

    @Mapping(target = "items", expression = "java(toItemDtos(order.getItems()))")
    OrderDto toDto(CustomerOrder order);

    default OrderItemDto toDto(CartItem item) {
        return new OrderItemDto(item.getProduct().getId(), item.getProduct().getName(), item.getQuantity(), item.getProduct().getPrice());
    }
}
