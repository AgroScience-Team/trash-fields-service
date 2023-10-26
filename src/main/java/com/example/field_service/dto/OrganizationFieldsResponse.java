package com.example.field_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class FieldResponse {
    private String name;
    private String squareArea;
    private String geom;
    private String description;
    private String color;
    private Date activityStart;
    private Date activityEnd;
}
