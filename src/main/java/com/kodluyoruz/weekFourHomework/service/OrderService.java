package com.kodluyoruz.weekFourHomework.service;

import com.kodluyoruz.weekFourHomework.model.Bill;
import com.kodluyoruz.weekFourHomework.model.entity.Order;
import com.kodluyoruz.weekFourHomework.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.kodluyoruz.weekFourHomework.model.mapper.OrderMapper.ORDER_MAPPER;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;


    public Order createOrder(Bill bill) {
        Order order = ORDER_MAPPER.billToOrder(bill);
        return orderRepository.save(order);
    }




}
