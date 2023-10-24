package com.example.field_service.dao.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "fields")
@Data
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "organization_id", nullable = false)
    private Long organizationId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "square_area", length = 40, nullable = false)
    private String squareArea;

    @Column(name = "geom", nullable = false)
    private String geom;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "color", length = 6, nullable = false)
    private String color;

    @Column(name = "activity_start")
    private Date activityStart;

    @Column(name = "activity_end")
    private Date activityEnd;

}
