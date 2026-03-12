package exam.springbootprog2api.service;

import exam.springbootprog2api.entity.Booking;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private final List<Booking> bookings = new ArrayList<>();

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Booking> addBooking(Booking booking) {

        if (booking.getRoomNumber() < 1 || booking.getRoomNumber() > 9) {
            throw new IllegalArgumentException("Room number must be between 1 and 9");
        }

        for (Booking b : bookings) {
            if (b.getRoomNumber() == booking.getRoomNumber()
                    && b.getBookingDate().equals(booking.getBookingDate())) {

                throw new IllegalStateException("Room already booked for this date");
            }
        }

        bookings.add(booking);

        return bookings;
    }
}