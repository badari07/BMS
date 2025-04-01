package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Payment extends BaseModel {
    private PaymentMode paymentMode;
    private String referenceNumber;
    private double amount;
    private PaymentStatus paymentStatus;
    private Show show;
    private User user;
    private Booking booking;
    private PaymentProvider paymentProvider;

}
