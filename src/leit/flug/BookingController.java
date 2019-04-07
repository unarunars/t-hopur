package leit.flug;

public class BookingController {
    private Booking booking;
    private ScheduledFlight[] foundFlights;


    public void createBooking() {
        booking = new Booking();
    }

    ScheduledFlight[] searchFlights(String departureAirport, String arrivalAirport, String date, int passengerAmount) {
        Schedule schedule = new Schedule();
        foundFlights = schedule.searchFlights(departureAirport, arrivalAirport, date, passengerAmount);
        return foundFlights;

    }

    void pickFlight(ScheduledFlight flight) throws NullPointerException {
        booking.setFlight(flight);
    }


    void completeBooking() {
        Schedule schedule = new Schedule();
        schedule.updateSchedule(booking);

    }


    void addPassenger(String name, boolean specNeeds, int luggageAmount, int flightClass, String seat) {

        booking.AddPassenger(name, specNeeds, luggageAmount, flightClass, seat);

    }
}
