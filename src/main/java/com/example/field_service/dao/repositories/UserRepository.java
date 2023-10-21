package com.example.field_service.dao.repositories;

import com.example.field_service.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("UPDATE User SET name = :name, surname = :surname where id = :id")
    @Modifying
    void updateNameAndAge(Long id, String name, String surname);
}
