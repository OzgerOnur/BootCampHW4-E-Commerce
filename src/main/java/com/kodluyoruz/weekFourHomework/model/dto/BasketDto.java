package com.kodluyoruz.weekFourHomework.model.dto;

import com.kodluyoruz.weekFourHomework.model.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketDto {
    private Integer basketId;
    private Integer userId;
    private List<ItemDto> items; // todo Item yapınca döngüye giriyor ?

}
