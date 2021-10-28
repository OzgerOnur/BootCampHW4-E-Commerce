package com.kodluyoruz.weekFourHomework.model.request;

import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateUserRequest {
    private String name;
    private String mail;

}
