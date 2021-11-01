package com.kodluyoruz.weekFourHomework.service;

import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.Order;
import com.kodluyoruz.weekFourHomework.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.kodluyoruz.weekFourHomework.model.mapper.OrderMapper.ORDER_MAPPER;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Basket basket) {
        Order order = ORDER_MAPPER.basketToOrder(basket);
        // BASKETLER için ayrı Orderlar için ayrı tablo tutalım
        // enginin videolar bak bari son
        return orderRepository.save(order);
    }






}
