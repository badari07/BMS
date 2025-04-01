package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Theatre extends BaseModel {
    private String name;

    @ManyToOne
    private Region region;

    @OneToMany
    private List<Screen> screens;
}
