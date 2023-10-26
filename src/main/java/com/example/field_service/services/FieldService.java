package com.example.field_service.services;

import com.example.field_service.dao.entities.Field;
import com.example.field_service.dao.repositories.FieldRepository;
import com.example.field_service.dto.FieldRequest;
import com.example.field_service.dto.FieldResponse;
import com.example.field_service.mappers.FieldMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FieldService {
    private final FieldRepository fieldRepository;
    private final FieldMapper fieldMapper;

    public List<Field> getAllOrganizationFields(Long organizationId) {
        return fieldRepository.findByOrganizationId(organizationId);
    }

    public FieldResponse addField(FieldRequest fieldRequest) {
        Field field = fieldMapper.fieldRequestToField(fieldRequest);
        field.setOrganizationId(fieldRequest.getOrganizationId());
        Field savedField = fieldRepository.save(field);
        return fieldMapper.fieldToFieldResponse(savedField);
    }

    public FieldResponse getField(Long id) {
        // Потом выбрасывать исключение
        Field field = fieldRepository.findById(id).orElse(null);
        return fieldMapper.fieldToFieldResponse(field);
    }

    public void deleteFieldById(Long id) {
        fieldRepository.findById(id).ifPresent(fieldRepository::delete);
    }

}
