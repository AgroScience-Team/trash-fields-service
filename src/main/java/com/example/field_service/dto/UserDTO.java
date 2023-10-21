package com.example.field_service.dto;

import com.example.field_service.dao.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String surname;

    public UserDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static UserDTO valueOf(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getSurname()
        );
    }

    public User mapToUser() {
        return new User(id, name, surname);
    }
}
