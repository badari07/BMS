package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Theatre extends BaseModel {
    private String name;
    private String region;
    private List<Screen> screens;
}
