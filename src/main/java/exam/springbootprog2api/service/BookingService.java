package exam.springbootprog2api.service;

import exam.springbootprog2api.entity.BookingEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private final List<BookingEntity> bookingEntities = new ArrayList<>();

    public List<BookingEntity> getBookings() {
        return bookingEntities;
    }

    public List<BookingEntity> addBooking(BookingEntity bookingEntity) {

        if (bookingEntity.getRoomNumber() < 1 || bookingEntity.getRoomNumber() > 9) {
            throw new IllegalArgumentException("Room number must be between 1 and 9");
        }

        for (BookingEntity b : bookingEntities) {
            if (b.getRoomNumber() == bookingEntity.getRoomNumber()
                    && b.getBookingDate().equals(bookingEntity.getBookingDate())) {

                throw new IllegalStateException("Room already booked for this date");
            }
        }

        bookingEntities.add(bookingEntity);

        return bookingEntities;
    }
}