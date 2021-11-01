package com.kodluyoruz.weekFourHomework.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Integer id;
    private Integer userId;
    private List<ItemDto> items;
    private Double price;

}
