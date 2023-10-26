package com.example.field_service.mappers;

import com.example.field_service.dao.entities.Field;
import com.example.field_service.dto.FieldResponse;
import com.example.field_service.dto.OrganizationFieldsResponse;
import com.example.field_service.dto.FieldRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FieldMapper {
    OrganizationFieldsResponse fieldToOrganizationFieldsResponse(Field field);

    Field fieldRequestToField(FieldRequest fieldRequest);

    FieldResponse fieldToFieldResponse(Field field);
}
