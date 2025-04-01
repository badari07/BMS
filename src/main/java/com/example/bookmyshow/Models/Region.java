package com.example.bookmyshow.Models;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Region extends BaseModel {
    private String name;
//    private List<Theatre> theatres;
}
