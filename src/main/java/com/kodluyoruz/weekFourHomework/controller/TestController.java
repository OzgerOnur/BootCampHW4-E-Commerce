package com.kodluyoruz.weekFourHomework.controller;

import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.Category;
import com.kodluyoruz.weekFourHomework.service.BasketService;
import com.kodluyoruz.weekFourHomework.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;


    @PostMapping
    public Category testMet(@RequestParam Integer i){

        return  null;
                //testService.test(i);


    }

}
