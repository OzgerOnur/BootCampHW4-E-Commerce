package com.kodluyoruz.weekFourHomework.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)//,optional = false
    @JoinColumn(name = "user_id",updatable = false,insertable = false,nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy ="basket",cascade = CascadeType.ALL)
    private List<Item> items;



}
