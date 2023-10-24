package com.example.field_service.dao.repositories;

import com.example.field_service.dao.entities.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {
    List<Field> findByOrganizationId(Long id);
}
