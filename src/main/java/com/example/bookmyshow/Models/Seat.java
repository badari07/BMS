package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel {
    private String number;
    private int rowNum;
    private String colNum;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

}
