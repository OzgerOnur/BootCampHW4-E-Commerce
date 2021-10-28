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

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = false)
    private User user;

    @OneToMany(mappedBy = "basket",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Item> items;

}
