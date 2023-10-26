package com.example.field_service.dto;

import lombok.Data;

@Data
public class FieldPreviewResponse {
    private String fieldName;
    private String cropName;
    private String color;
    private String geom;
}
