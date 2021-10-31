package com.kodluyoruz.weekFourHomework.model.dto;

import com.kodluyoruz.weekFourHomework.model.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDto {
    private Integer basketId;
    private Integer userId;
    private List<ItemDto> items;
    private Double price;

}
