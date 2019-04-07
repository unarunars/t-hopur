package sample;

import leit.flug.Schedule;
import leit.flug.ScheduledFlight;
import leit.hotel.HotelsDAO;

import java.util.ArrayList;

public class Fetcher {

    public ArrayList getAllHotels() {
        HotelsDAO hotel = new HotelsDAO();
        ArrayList hotels = hotel.getAllHotels();
        return hotels;
    }

    public ArrayList getAllFlights() {
        Schedule schedule = new Schedule();
        ScheduledFlight[] flights = schedule.getAllFlights();
        ArrayList realFlights = new ArrayList<>();
        for (int i = 0; i< flights.length; i++) {
            realFlights.add(flights[i]);
        }
        return realFlights;
    }

    public ArrayList getAllTrips() {
        hopurd.main.API.initDB();
        ArrayList trips = hopurd.main.API.getAllTrips();
        return trips;
    }
}
