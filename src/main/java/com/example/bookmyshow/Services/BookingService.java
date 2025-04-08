package com.example.bookmyshow.Services;

import com.example.bookmyshow.Execptions.ShowNotFoundExpection;
import com.example.bookmyshow.Execptions.ShowSeatNotFoundExecption;
import com.example.bookmyshow.Execptions.UserNotFoundExecption;
import com.example.bookmyshow.Models.*;

import com.example.bookmyshow.Repositories.BookingRepository;
import com.example.bookmyshow.Repositories.ShowRepository;
import com.example.bookmyshow.Repositories.ShowSeatRepository;
import com.example.bookmyshow.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;
    private PriceCalculater priceCalculater;

    public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository,
                          BookingRepository bookingRepository, PriceCalculater priceCalculater) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculater = priceCalculater;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, Long showId, List<Long> seatIds) throws UserNotFoundExecption, ShowNotFoundExpection, ShowSeatNotFoundExecption {



        /**
         * 1. Get the user by userId
         * 2. Get the show by showId
         * 3. Get the list of Showseats with the given seatIds
         ---Take a lock ---
         * 4. Check if the seats are  available or not
         * 5. if not, throw an exception
         * 6. if yes, mark the status of all the seats as blocked
         ----- relese the lock -----
         * 4. save the changes in the DB as well
         * 5. Create a booking with pending status[ save booking obj to DB]
         * 6. Return the booking object
         */

        //1. Get the user by userId
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundExecption("User with id " + userId + " not found");
        }

        User user = optionalUser.get();

        //2. Get the show by showId
        Optional<Show> optionalShow = showRepository.findById(showId);
        if (optionalShow.isEmpty()) {
            throw new ShowNotFoundExpection("Show with id " + showId + " not found");
        }

        Show show = optionalShow.get();


        List<ShowSeat> showSeats = showSeatRepository.findAllById(seatIds);

        if (seatIds.size() != showSeats.size()) {
            throw new ShowSeatNotFoundExecption("ShowSeat with id " + seatIds + " not available");
        }else {
            for (ShowSeat showSeat : showSeats) {
                if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                    throw new ShowSeatNotFoundExecption("ShowSeat with id " + showSeat.getId() + " not available");
                }else {
                    showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
                    showSeatRepository.save(showSeat);
                }
            }
           // showSeatRepository.saveAll(showSeats);
        }

        // 5. Create a booking with pending status[ save booking obj to DB]
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculater.calculatePrice(showSeats,show)); // Set the amount to 0 for now, you can update it later
        booking.setShowSeats(showSeats);

        // Save the booking to the database
         // Uncomment this line when you have a booking repository

        return bookingRepository.save(booking);




        // Logic to create a booking
        //return null;

    }
}
