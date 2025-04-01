package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ShowSeatType extends BaseModel {

        @ManyToOne
        private Show show;

        @Enumerated(EnumType.ORDINAL)
        private SeatType seatType;

        private int price;
}
