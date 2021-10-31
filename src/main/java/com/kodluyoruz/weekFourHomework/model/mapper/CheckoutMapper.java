package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.Bill;
import com.kodluyoruz.weekFourHomework.model.dto.CheckoutDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.Order;
import com.kodluyoruz.weekFourHomework.model.request.CheckoutRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface CheckoutMapper {
    CheckoutMapper CHECKOUT_MAPPER = Mappers.getMapper(CheckoutMapper.class);

    Order basketToOrder(Basket basket);

    CheckoutDto checkoutBasketToDto(Basket basket);

    Bill BasketToBill(Basket basket);

    CheckoutDto billToCheckoutDto(Bill bill);



}
