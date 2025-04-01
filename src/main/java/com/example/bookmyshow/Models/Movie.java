package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Movie extends BaseModel {
    private String name;
    private List<Feature> features;
    private Date releaseDate;
}
