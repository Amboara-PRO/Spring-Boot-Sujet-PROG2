package exam.springbootprog2api.controller;

import exam.springbootprog2api.entity.BookingEntity;
import exam.springbootprog2api.service.BookingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingEntity> getBookings() {
        return bookingService.getBookings();
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BookingEntity bookingEntity) {

        try {
            List<BookingEntity> result = bookingService.addBooking(bookingEntity);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
}