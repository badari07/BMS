package com.example.bookmyshow.Services;

import com.example.bookmyshow.Models.Show;
import com.example.bookmyshow.Models.ShowSeat;
import com.example.bookmyshow.Models.ShowSeatType;
import com.example.bookmyshow.Repositories.ShowSeatRepository;
import com.example.bookmyshow.Repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculater {

    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculater(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> showSeats, Show show) {
    List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        int totalPrice = 0;
        for (ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    totalPrice += showSeatType.getPrice();
                    break;
                }

            }

        }
        return totalPrice;

    }
}
