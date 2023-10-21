package com.example.field_service.services;

import com.example.field_service.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO save(UserDTO userDTO);

    void update(Long id, UserDTO userDTO);

    void delete(Long id);
}
