package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import jdk.jfr.Enabled;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Booking extends BaseModel {
    private String bookingId;
    private User user;
    private Show show;
    private List<ShowSeat> showSeats;
    private List<Payment> payments;
    private BookingStatus bookingStatus;
    private double amount;


    // Additional fields and methods can be added as needed
}
