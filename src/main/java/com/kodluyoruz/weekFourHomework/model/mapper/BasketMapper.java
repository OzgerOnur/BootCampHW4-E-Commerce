package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.dto.BasketDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface BasketMapper {

    BasketMapper BASKET_MAPPER = Mappers.getMapper(BasketMapper.class);


    BasketDto toBasketDto(Basket basket);

}
