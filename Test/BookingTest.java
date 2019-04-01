import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Booking;
import sample.Package;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    Package myPackage = new Package();
    Booking book = new Booking();

    @BeforeEach
    void setUp() {

        myPackage.setDestination("Akureyri");
        myPackage.setFlightDate("01.06.18");
        myPackage.setFlightSeats(20);
        myPackage.setHotel("Hótel Akureyri");
        myPackage.setHotelDate("01.06.18");
        myPackage.setHotelRooms(5);
        myPackage.setEvent("Bjórbað");
        myPackage.setEventDate("05.06.18");
        myPackage.setEventSeats(10);
    }

    @AfterEach
    void tearDown() {
        myPackage = null;
    }

    @Test
    void testRemoveFlights() {
        book.removeFlights(4, myPackage);
        assertEquals(16, myPackage.getFlightSeats());
    }

    @Test
    void removeHotels() {
        book.removeHotels(2, myPackage);
        assertEquals(3, myPackage.getHotelRooms());
    }

    @Test
    void removeEvents() {
        book.removeEvents(4, myPackage);
        assertEquals(6, myPackage.getEventSeats());
    }
    @Test
    void queryTest(){
        boolean check = book.updateSeats(2, myPackage);
        assertEquals(true, check);

    }
    @Test
    void queryTest2(){
        boolean check = book.updateSeats(2, null);
        assertEquals(false, check);

    }
}