package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel {
    private String number;
    private int rowNum;
    private String colNum;
    private SeatType seatType;

}
