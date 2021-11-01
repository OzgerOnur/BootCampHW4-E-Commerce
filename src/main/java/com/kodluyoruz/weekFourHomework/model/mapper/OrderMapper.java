package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.dto.OrderDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.MappingControl;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "id",ignore = true)
    Order basketToOrder(Basket basket);

    OrderDto orderToOrderDto(Order order);

}
