package com.kodluyoruz.weekFourHomework.repository;

import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Integer> {
}
