package com.example.rmapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    private long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
}
