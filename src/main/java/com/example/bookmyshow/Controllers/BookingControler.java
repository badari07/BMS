package com.example.bookmyshow.Controllers;

import com.example.bookmyshow.Dtos.CreateBookingRequestDto;
import com.example.bookmyshow.Dtos.CreateBookingResponsetDto;
import com.example.bookmyshow.Dtos.Responestatus;
import com.example.bookmyshow.Execptions.ShowNotFoundExpection;
import com.example.bookmyshow.Execptions.ShowSeatNotFoundExecption;
import com.example.bookmyshow.Execptions.UserNotFoundExecption;
import com.example.bookmyshow.Models.Booking;
import com.example.bookmyshow.Services.BookingService;
import org.springframework.stereotype.Controller;

import java.awt.print.Book;

@Controller
public class BookingControler {
    private BookingService bookingService;
    public BookingControler(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public CreateBookingResponsetDto createBooking(CreateBookingRequestDto createBookingRequestDto)  {
        CreateBookingResponsetDto createBookingResponsetDto = new CreateBookingResponsetDto();
        try {
            Booking booking = bookingService.createBooking(createBookingRequestDto.getUserId(),
                    createBookingRequestDto.getShowId(), createBookingRequestDto.getShowSeatId());

            createBookingResponsetDto.setBookingId(booking.getId());
            createBookingResponsetDto.setResponestatus(Responestatus.SUCCESS);
        } catch (UserNotFoundExecption e) {
                createBookingResponsetDto.setResponestatus(Responestatus.FAILURE);
            throw new RuntimeException(e);
        } catch (ShowNotFoundExpection e) {
            createBookingResponsetDto.setResponestatus(Responestatus.FAILURE);
            throw new RuntimeException(e);
        } catch (ShowSeatNotFoundExecption e) {
            createBookingResponsetDto.setResponestatus(Responestatus.FAILURE);
            throw new RuntimeException(e);
        }

        return createBookingResponsetDto;


    }
}
