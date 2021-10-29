package com.kodluyoruz.weekFourHomework.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @ManyToOne(optional = false)
    private Product product;

    @Column(name = "basket_id")
    private Integer basketId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "basket_id",nullable = false,updatable = false,insertable = false)
    private Basket basket;






}
