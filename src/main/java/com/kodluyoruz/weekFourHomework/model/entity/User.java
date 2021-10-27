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

    @Column(length = 100,nullable = false)
    private String password;

    @Column()
    @OneToOne
    private Basket Basket;


    @OneToMany
    private List<Order> OrderNos;




}
