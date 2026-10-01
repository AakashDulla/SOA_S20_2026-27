package com.example.CinePass.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CinePass.DTO.BookingDTO;
import com.example.CinePass.Entity.Booking;
import com.example.CinePass.Entity.BookingStatus;
import com.example.CinePass.Entity.Show;
import com.example.CinePass.Entity.User;
import com.example.CinePass.Repository.BookingRepository;
import com.example.CinePass.Repository.ShowRepository;
import com.example.CinePass.Repository.UserRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Booking createBooking(BookingDTO bookingDTO) {
        if (bookingDTO.getSeatNumbers() == null || bookingDTO.getNumberOfSeats() == null) {
            throw new RuntimeException("Seat numbers and number of seats cannot be null");
        }

        Show show = showRepository.findById(bookingDTO.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found"));

        if (!isSeatsAvailable(show, bookingDTO.getNumberOfSeats())) {
            throw new RuntimeException("Not enough seats are available");
        }

        if (bookingDTO.getSeatNumbers().size() != bookingDTO.getNumberOfSeats()) {
            throw new RuntimeException("Seat numbers and numbers of seats must be equal");
        }
        
        validateDuplicateSeats(show, bookingDTO.getSeatNumbers());

        User user = userRepository.findById(bookingDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setNumberOfSeats(bookingDTO.getNumberOfSeats());
        booking.setSeatNumbers(bookingDTO.getSeatNumbers());
        
        Double priceAsDouble = show.getPrice() != null ? show.getPrice().doubleValue() : null;
        booking.setPrice(calculateTotalAmount(priceAsDouble, bookingDTO.getNumberOfSeats()));
        booking.setBookingTime(LocalDateTime.now());
        booking.setBookingStatus(BookingStatus.PENDING);

        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBooking(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Booking> getShowBooking(Long showId) {
        return bookingRepository.findByShowId(showId);
    }

    public List<Booking> getBookingsByStatus(BookingStatus status) {
        return bookingRepository.findByBookingStatus(status);
    }

    @Transactional
    public Booking confirmBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        if (booking.getBookingStatus() != BookingStatus.PENDING) {
            throw new RuntimeException("Booking is not in pending state");
        }
        
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        return bookingRepository.save(booking);
    }

    @Transactional
    public Booking cancelbooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        validateCancellation(booking);

        booking.setBookingStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }

    public void validateCancellation(Booking booking) {
        LocalDateTime showTime = booking.getShow().getShowTime();
        LocalDateTime deadlineTime = showTime.minusHours(2);

        if (LocalDateTime.now().isAfter(deadlineTime)) {
            throw new RuntimeException("Cannot cancel the booking within 2 hours of show time");
        }
        if (booking.getBookingStatus() == BookingStatus.CANCELLED) {
            throw new RuntimeException("Booking already cancelled");
        }
    }

    public boolean isSeatsAvailable(Show show, Integer numberOfSeats) {
        List<Booking> bookings = bookingRepository.findByShowId(show.getId());
        
        int bookedSeats = bookings.stream()
                .filter(booking -> booking.getBookingStatus() != BookingStatus.CANCELLED)
                .mapToInt(Booking::getNumberOfSeats)
                .sum();
                
        return (show.getTheatre().getTheatreCapacity() - bookedSeats) >= numberOfSeats;
    }

    public void validateDuplicateSeats(Show show, List<String> seatNumbers) {
        List<Booking> bookings = bookingRepository.findByShowId(show.getId());
        
        Set<String> occupiedSeats = bookings.stream()
                .filter(b -> b.getBookingStatus() != BookingStatus.CANCELLED)
                .flatMap(b -> (b.getSeatNumbers() != null ? b.getSeatNumbers() : Collections.<String>emptyList()).stream())
                .collect(Collectors.toSet());
                
        List<String> duplicateSeats = seatNumbers.stream()
                .filter(occupiedSeats::contains)
                .collect(Collectors.toList());

        if (!duplicateSeats.isEmpty()) {
            throw new RuntimeException("Seats are already booked: " + duplicateSeats);
        }
    }

    public Double calculateTotalAmount(Double price, Integer numberOfSeats) {
        if (price == null || numberOfSeats == null) {
            return 0.0;
        }
        return price * numberOfSeats;
    }
}