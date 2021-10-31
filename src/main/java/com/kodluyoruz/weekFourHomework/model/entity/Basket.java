package com.kodluyoruz.weekFourHomework.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "baskets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @OneToOne(fetch = FetchType.LAZY)//,optional = false
    @JoinColumn(name = "user_id",nullable = false,updatable = false, insertable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "basket",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Item> items;

}
