package com.example.field_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class FieldRequest {
    @JsonIgnore
    private Long organizationId;

    private String name;
    private String squareArea;
    private String geom;
    private String description;
    private String color;
    private Date activityStart;
    private Date activityEnd;
}
