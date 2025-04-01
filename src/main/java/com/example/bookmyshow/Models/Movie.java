package com.example.bookmyshow.Models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Movie extends BaseModel {
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    private Date releaseDate;
}
