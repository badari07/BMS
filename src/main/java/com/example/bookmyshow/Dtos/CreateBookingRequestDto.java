package com.example.bookmyshow.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {
    private Long showId; //can be skipped as we have showSeatId
    private Long userId;
    private List<Long> showSeatId;

}
