package com.example.field_service.mappers;

import com.example.field_service.dao.entities.Field;
import com.example.field_service.dto.FieldResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FieldMapper {
    FieldResponse fieldToFieldResponse(Field field);
}
