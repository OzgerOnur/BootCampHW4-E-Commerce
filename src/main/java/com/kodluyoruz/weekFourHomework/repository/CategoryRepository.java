package com.kodluyoruz.weekFourHomework.repository;

import com.kodluyoruz.weekFourHomework.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
