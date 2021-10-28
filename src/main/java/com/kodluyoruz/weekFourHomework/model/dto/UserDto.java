package com.kodluyoruz.weekFourHomework.model.dto;

import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String mail;
    private BasketDto basketDto;

}
