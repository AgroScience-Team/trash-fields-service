package com.example.field_service.services;

import com.example.field_service.dao.entities.Field;
import com.example.field_service.dao.repositories.FieldRepository;
import com.example.field_service.dto.FieldPreviewResponse;
import com.example.field_service.dto.FieldRequest;
import com.example.field_service.dto.FieldResponse;
import com.example.field_service.mappers.FieldMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Требует реафакторинга в плане обработки краевых случаев
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

    public List<Field> getFieldsPreview() {
        return fieldRepository.findAll();
    }

    public Field getFieldPreview(Long fieldId) {
        // временно если не нашли возвращаем null
        return fieldRepository.findById(fieldId).orElse(null);
    }

    public FieldResponse updateFieldById(FieldRequest fieldRequest, Long fieldId) {
        Field field = fieldRepository.findById(fieldId).orElseThrow(EntityNotFoundException::new);

        field.setName(fieldRequest.getName());
        field.setSquareArea(fieldRequest.getSquareArea());
        field.setDescription(fieldRequest.getDescription());
        field.setColor(fieldRequest.getColor());
        field.setActivityStart(fieldRequest.getActivityStart());
        field.setGeom(fieldRequest.getGeom());
        field.setActivityEnd(fieldRequest.getActivityEnd());
        return fieldMapper.fieldToFieldResponse(fieldRepository.save(field));
    }
}
