package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.dto.ItemDto;
import com.kodluyoruz.weekFourHomework.model.entity.Item;
import com.kodluyoruz.weekFourHomework.model.request.ItemRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper ITEM_MAPPER = Mappers.getMapper(ItemMapper.class);

    ItemDto itemToDto(Item item);

    Item requestToItem(ItemRequest itemRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateItem(@MappingTarget Item item, ItemRequest itemRequest);

}
