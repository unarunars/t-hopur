package leit.flug;

public class Booking {

    private String number;
    private int price;
    private Passenger[] passengers;
    private ScheduledFlight flight;

    Booking(){
        //We assume 1 passenger for 1 booking, any further can be added later
        passengers = new Passenger[1];
    }

    void setFlight(ScheduledFlight flight){
        this.flight = flight;
        this.number = flight.getFlight().getNumber();
        this.price = flight.getFlight().getTripPrice();
    }

    public String getNumber(){
        return number;
    }

    public int getPrice(){
        return price;
    }

    public ScheduledFlight getFlight(){
        return flight;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void AddPassenger(String name, boolean specialNeeds, int luggage, int flightClass, String seat){
        //Copy passengers and increase size by 1
        Passenger[] passengersCopy = new Passenger[passengers.length+1];
        for(int i = 0; i < passengers.length; i++)
            passengersCopy[i] = passengers[i];

        //Create new passenger
        Passenger passenger = new Passenger(name, specialNeeds, luggage, flightClass, seat);
        passengersCopy[passengers.length-1] = passenger;

        //Update current passengers
        passengers = passengersCopy;
    }
}
