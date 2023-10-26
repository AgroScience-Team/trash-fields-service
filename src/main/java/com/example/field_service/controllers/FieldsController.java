package com.example.field_service.controllers;

import com.example.field_service.dto.FieldPreviewResponse;
import com.example.field_service.dto.FieldRequest;
import com.example.field_service.dto.FieldResponse;
import com.example.field_service.dto.OrganizationFieldsResponse;
import com.example.field_service.mappers.FieldMapper;
import com.example.field_service.services.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/vi/fields")
public class FieldsController {
    private final FieldService fieldService;
    private final FieldMapper fieldMapper;

    @GetMapping
    public List<OrganizationFieldsResponse> getCurrentOrganizationFields(@RequestParam Long organization_id) {
        return fieldService.getAllOrganizationFields(organization_id)
                .stream()
                .map(fieldMapper::fieldToOrganizationFieldsResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public FieldResponse createField(@RequestBody FieldRequest fieldRequest, @RequestParam Long organizationId) {
        fieldRequest.setOrganizationId(organizationId);
        return fieldService.addField(fieldRequest);
    }

    @GetMapping("/{fieldId}")
    public FieldResponse getField(@PathVariable Long fieldId) {
        return fieldService.getField(fieldId);
    }

    @DeleteMapping("/{fieldId}")
    public ResponseEntity<Void> deleteField(@PathVariable Long fieldId) {
        fieldService.deleteFieldById(fieldId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/preview")
    public List<FieldPreviewResponse> getFieldsPreview() {
        // Нужна логика для связывания с сервисом посевов
        return fieldService.getFieldsPreview()
                .stream()
                .map(fieldMapper::fieldToFieldPreviewResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/preview/{fieldId}")
    public FieldPreviewResponse getFieldPreview(@PathVariable Long fieldId) {
        // Нужна логика для связывания с сервисом посевов
        return fieldMapper.fieldToFieldPreviewResponse(
                    fieldService.getFieldPreview(fieldId)
            );
    }

    @PutMapping("/{fieldId}")
    public FieldResponse updateField(@RequestBody FieldRequest fieldRequest, @PathVariable Long fieldId) {
        return fieldService.updateFieldById(fieldRequest, fieldId);
    }
}

