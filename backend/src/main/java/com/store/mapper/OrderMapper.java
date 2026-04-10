package com.store.mapper;

import com.store.dto.OrderDto;
import com.store.dto.OrderItemDto;
import com.store.entity.CustomerOrder;
import com.store.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "items", source = "items")
    OrderDto toDto(CustomerOrder order);

    List<OrderDto> toDtos(List<CustomerOrder> orders);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.name")
    OrderItemDto toItemDto(OrderItem item);
}
