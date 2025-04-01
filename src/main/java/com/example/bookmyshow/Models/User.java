package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private List<Booking> bookings;
}
