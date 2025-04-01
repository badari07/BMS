package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ShowSeat extends BaseModel {
    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}
