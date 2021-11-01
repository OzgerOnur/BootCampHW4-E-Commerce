package com.kodluyoruz.weekFourHomework.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders_items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne()
    @JoinColumn(name = "product_id",nullable = false,updatable = false,insertable = false)
    private Product product;

    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne()// optional = false
    @JoinColumn(name = "basket_id",nullable = false,updatable = false,insertable = false)
    private Order order;

}