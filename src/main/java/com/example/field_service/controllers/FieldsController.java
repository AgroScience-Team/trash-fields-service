package com.example.field_service.controllers;

import com.example.field_service.dto.FieldResponse;
import com.example.field_service.mappers.FieldMapper;
import com.example.field_service.services.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/vi/fields")
public class FieldsController {
    private final FieldService fieldService;
    private final FieldMapper fieldMapper;

    @GetMapping
    public List<FieldResponse> getCurrentOrganizationFields(@RequestParam Long organization_id) {
        return fieldService.getAllOrganizationFields(organization_id)
                .stream()
                .map(fieldMapper::fieldToFieldResponse)
                .collect(Collectors.toList());
    }
}

