package com.example.rmapp.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="menu_item")
public class MenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;

    private double price;

    private String imageUrl;

}
