package com.harshita.carmatchmaker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private Long id;
    private String make;
    private String model;
    private int price;
    private double mileage;
    private int safetyRating;
    private String category;
    private String review;
}
