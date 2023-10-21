package com.example.field_service.services.impl;

import com.example.field_service.dao.entities.User;
import com.example.field_service.dao.repositories.UserRepository;
import com.example.field_service.dto.UserDTO;
import com.example.field_service.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(UserDTO::valueOf)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userDTO.mapToUser();
        return UserDTO.valueOf(userRepository.save(user));
    }

    @Override
    @Transactional
    public void update(Long id, UserDTO userDTO) {
        User currentUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);

        User user = userDTO.mapToUser();
        String name = user.getName();
        String surname = user.getSurname();

        userRepository.updateNameAndAge(id, name, surname);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        userRepository.deleteById(id);
    }
}
