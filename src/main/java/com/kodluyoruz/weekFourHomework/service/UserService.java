package com.kodluyoruz.weekFourHomework.service;

import com.kodluyoruz.weekFourHomework.exceptions.errors.NotFoundException;
import com.kodluyoruz.weekFourHomework.model.dto.UserDto;
import com.kodluyoruz.weekFourHomework.model.entity.User;
import com.kodluyoruz.weekFourHomework.model.request.CreateUpdateUserRequest;
import com.kodluyoruz.weekFourHomework.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.weekFourHomework.model.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public UserDto createUser(CreateUpdateUserRequest request) {
        User user = USER_MAPPER.createUser(request);
        User createdUser = userRepository.save(user);
        return USER_MAPPER.toUserDto(createdUser);
    }


    public UserDto getUser(int id) {
        User user = userRepository.getById(id);
        return USER_MAPPER.toUserDto(user);
    }

    public UserDto updateUser(int id, CreateUpdateUserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException());
        USER_MAPPER.updateUser(user,request);
        User createdUser = userRepository.save(user);
        return USER_MAPPER.toUserDto(createdUser);
    }

    public List<UserDto> getUsers(String name) {
        List<User> users = userRepository.findAll();
        return USER_MAPPER.toUserDtoList(users);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}