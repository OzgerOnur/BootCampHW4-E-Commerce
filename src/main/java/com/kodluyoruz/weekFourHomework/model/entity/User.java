package com.kodluyoruz.weekFourHomework.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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
    private String mail;



    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy ="user",orphanRemoval = true)//mappedBy ="user",optional = false,
    private Basket basket;

    @OneToMany(fetch = FetchType.LAZY,mappedBy ="user",cascade = CascadeType.ALL) //mappedBy ="user",
    private List<Order> Orders;




}
