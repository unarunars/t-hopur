package sample;

import java.util.ArrayList;

public class Booking {

    public void bookTrip(int touristCount, Package soldPackage) {
        removeFlights(touristCount, soldPackage);
        removeHotels(touristCount, soldPackage);
        removeEvents(touristCount, soldPackage);
    }

    public void removeFlights(int touristCount, Package soldPackage) {
        soldPackage.removeFlightSeats(touristCount);
    }
    public void removeHotels(int touristCount, Package soldPackage) {
        soldPackage.removeHotelSeats(touristCount);
    }
    public void removeEvents(int touristCount, Package soldPackage) {
        soldPackage.removeEventSeats(touristCount);
    }

}
