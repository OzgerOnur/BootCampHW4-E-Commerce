package com.kodluyoruz.weekFourHomework.controller;

import com.kodluyoruz.weekFourHomework.model.dto.BasketDto;
import com.kodluyoruz.weekFourHomework.model.request.AddUpdateBasketRequest;
import com.kodluyoruz.weekFourHomework.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PostMapping// if i putted there get, i couldnt have sent requestbody. i wanna send put because i dont wanna basket id being seen
    public BasketDto getBasket(@RequestBody AddUpdateBasketRequest basketRequest){
        return basketService.getBasket(basketRequest);
    }

    @PutMapping
    public BasketDto updateBasket(@RequestBody AddUpdateBasketRequest basketRequest){
        return basketService.putBasket(basketRequest);
    }

    @PatchMapping
    public BasketDto addBasket(@RequestBody AddUpdateBasketRequest addRequest){
        return basketService.addBasket(addRequest);

    }

    @DeleteMapping
    public BasketDto removeBasket(@RequestBody AddUpdateBasketRequest removeRequest){
        return basketService.removeItemFromBasket(removeRequest);

    }




}