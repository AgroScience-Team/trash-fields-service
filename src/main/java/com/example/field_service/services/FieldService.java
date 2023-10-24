package com.example.field_service.services;

import com.example.field_service.dao.entities.Field;
import com.example.field_service.dao.repositories.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FieldService {
    private final FieldRepository fieldRepository;

    public List<Field> getAllOrganizationFields(Long organizationId) {
        return fieldRepository.findByOrganizationId(organizationId);
    }
}
