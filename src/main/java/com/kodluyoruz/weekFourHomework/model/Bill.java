package com.kodluyoruz.weekFourHomework.model;

import com.kodluyoruz.weekFourHomework.model.dto.ItemDto;
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
public class Bill {
    private Integer basketId;
    private Integer userId;
    private List<ItemDto> items;
    private Double price;

}