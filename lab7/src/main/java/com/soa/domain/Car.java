package com.soa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String registerNumber;
    private String mark;
    private String model;
    private String color;
    private String yearOfProduction;

    @Column(columnDefinition = "TEXT", length = 1000)
    private String description;

}
