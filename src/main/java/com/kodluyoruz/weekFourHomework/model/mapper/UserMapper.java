package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.dto.UserDto;
import com.kodluyoruz.weekFourHomework.model.entity.User;
import com.kodluyoruz.weekFourHomework.model.request.CreateUpdateUserRequest;
import org.mapstruct.*;
import org.mapstruct.control.MappingControl;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring") //uses = {BasketMapper.class}
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);


    @Mapping(target = "basketDto",source = "basket")
    UserDto toUserDto(User user);


    User createUser(CreateUpdateUserRequest createUpdateUserRequest);

    List<UserDto> toUserDtoList(List<User> user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(@MappingTarget User user, CreateUpdateUserRequest request);





}
