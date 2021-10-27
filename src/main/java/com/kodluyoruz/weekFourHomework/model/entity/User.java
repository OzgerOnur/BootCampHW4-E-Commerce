package com.kodluyoruz.weekFourHomework.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100,nullable = false)
    private String name;

    @Column(length = 100,nullable = false)
    private String surname;

    @Column(length = 100,nullable = false)
    private String mail;


    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL,optional = false)
    private Basket basket;

    @OneToMany(mappedBy ="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)//todo Cascase tipleirne bak
    private List<Order> Orders;




}
