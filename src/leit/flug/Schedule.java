package leit.flug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Schedule {

    public void updateSchedule(Booking booking){
        //They key values used to access the scheduled flight we wish to update
        String date = booking.getFlight().getScheduledDate();
        String number = booking.getFlight().getFlight().getNumber();

        DatabaseManager dm = new DatabaseManager();
        dm.updateScheduledFlight(date, number, booking);
    }


    public ScheduledFlight[] getAllFlights() {
        DatabaseManager dm = new DatabaseManager();
        ScheduledFlight[] scheduledFlights = dm.getScheduledFlights();
        return scheduledFlights;
    }


        public ScheduledFlight[] searchFlights(String departureAirport, String arrivalAirport, String date){
        DatabaseManager dm = new DatabaseManager();
        ScheduledFlight[] scheduledFlights = dm.getScheduledFlights();

        //System.out.println(scheduledFlights[0]);

        List<ScheduledFlight> sFList = new ArrayList<>();

        for(ScheduledFlight sf : scheduledFlights){
            if(sf.getScheduledDate().equals(date) &&
               sf.getFlight().getArrivalAirport().equals(arrivalAirport) &&
               sf.getFlight().getDepartureAirport().equals(departureAirport))
                sFList.add(sf);
        }
        ScheduledFlight[] foundFlights = new ScheduledFlight[sFList.size()];

        for(int i = 0; i < foundFlights.length; i++)
            foundFlights[i] = sFList.get(i);


        return foundFlights;
    }

    public ScheduledFlight[] searchFlights(String departureAirport, String arrivalAirport, String date, int passengerAmount){
        ScheduledFlight[] foundFlights = searchFlights(departureAirport, arrivalAirport, date);
        List<ScheduledFlight> f = new ArrayList<>(Arrays.asList(foundFlights));
        f.removeIf(n -> n.getSeatsLeft() < passengerAmount );

        ScheduledFlight[] filteredFlights = new ScheduledFlight[f.size()];
        for(int i = 0; i < filteredFlights.length; i++)
            filteredFlights[i] = f.get(i);

        return filteredFlights;
    }

    public static void main(String[] args){
        Schedule schedule = new Schedule();
        ScheduledFlight[] flights = schedule.searchFlights("BIU",
                                                                  "AEY",
                                                                  "2019-1-12");
        ScheduledFlight flight = flights[0];
        ScheduledFlight[] flights = schedule.getAllFlights();
        Flight currFlight;
        for (int i = 0; i<flights.length; i++) {
            currFlight = flights[i].getFlight();
            System.out.println(currFlight.getArrivalAirport());
        }
        /*
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.AddPassenger("Frank Bologna", false, 1, 1, "A0");
        booking.AddPassenger("Molly Fish", false, 1, 1, "C0");
        schedule.updateSchedule(booking);
        */
    }
}
