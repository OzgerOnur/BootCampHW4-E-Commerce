package com.kodluyoruz.weekFourHomework.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 100, nullable = false)
    private String name;

    @Column(length = 150)
    private String description;

    @Column(nullable = false)
    private Double price;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product",cascade = CascadeType.ALL) //mappedBy = "product",
    private List<Item> items;

 //?? todo category islerini duzelt
    @Column(name = "category_id",nullable = false)
    private Integer categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false, insertable = false, updatable = false)
    private Category category;

}
