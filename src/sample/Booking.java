package sample;

import hopurd.database.BookingQueries;
import hopurd.database.DepartureQueries;
import hopurd.database.UserQueries;
import hopurd.models.*;
import leit.flug.Schedule;
import leit.flug.ScheduledFlight;
import leit.hotel.Hotel;
import leit.hotel.Room;

import java.util.ArrayList;

public class Booking {

    public boolean bookPackage(String date, int touristCount, Package soldPackage) {
        //FlugCheck
        Schedule schedule = new Schedule();
        ScheduledFlight[] flights = schedule.searchFlights( soldPackage.getDepartureDestinationID(),
                                                            soldPackage.getDestinationID(),
                                                            date);
        if (flights == null) return false;

        //HotelCheck
        boolean confirmHotel = checkHotel(touristCount, soldPackage.getHotel());

        if (!confirmHotel) return false;

        return true;
    }

    public void bookPackageFinal(String date, int touristCount, Package soldPackage) {
        Schedule schedule = new Schedule();
        ScheduledFlight[] flights = schedule.searchFlights( soldPackage.getDepartureDestinationID(),
                                                            soldPackage.getDestinationID(),
                                                            date);
        Trip trip = soldPackage.getEvent();
        Departure departure = DepartureQueries.getAllTripDepartures(trip.getId()).get(0);
        User user = UserQueries.getUser("admin");
        hopurd.models.Booking booking = new hopurd.models.Booking(user, departure, Enums.Status.PAID);
        for (int i = 0; i<touristCount;i++) BookingQueries.insertBooking(booking);


        bookFlight(flights[0], date, touristCount, schedule);
    }

    public void bookFlight(ScheduledFlight flight, String date, int touristCount, Schedule schedule) {
        leit.flug.Booking booking = new leit.flug.Booking();
        booking.setFlight(flight);
        for (int i = 0; i<touristCount; i++) {
            booking.AddPassenger("Pakkaflakk kúnni", false, 1, 1, "A" + i);
        }
        schedule.updateSchedule(booking);
    }

    public boolean checkHotel(int touristCount, Hotel hotelName) {
        Fetcher fetch = new Fetcher();
        ArrayList hotels = fetch.getAllHotels();
        Hotel currHotel = null;
        for (int i = 0; i<hotels.size(); i++) {
            currHotel = (Hotel) hotels.get(i);
            if (currHotel.getName().equals(hotelName.getName())) {
                return checkRooms(touristCount, currHotel.getRooms());
            }
        }
        return false;
    }

    public boolean checkRooms(int touristCount, ArrayList rooms) {
        Room currRoom = null;
        int beds = 0;
        for (int i = 0; i<rooms.size(); i++) {
            currRoom = (Room) rooms.get(i);
            beds += currRoom.getGuests();
        }

        return (beds >= touristCount);
    }
}
