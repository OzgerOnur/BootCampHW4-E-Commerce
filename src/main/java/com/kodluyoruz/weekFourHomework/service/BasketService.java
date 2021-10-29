package com.kodluyoruz.weekFourHomework.service;


import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.User;
import com.kodluyoruz.weekFourHomework.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;

    protected Basket createBasket(Integer userId){
        Basket basket = Basket.builder().userId(userId).build();
        return basketRepository.save(basket);

    }

}
