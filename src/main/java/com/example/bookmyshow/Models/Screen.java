package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Screen extends BaseModel {
    private String name;
    private List<Seat> seats;
    private List<Feature> features;
}
