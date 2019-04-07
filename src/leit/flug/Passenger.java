package leit.flug;

public class Passenger {

    private String name;
    private boolean specialNeeds;
    private int luggage;
    private int flightClass;
    private String seat;


    Passenger(String name, boolean specialNeeds, int luggage, int flightClass, String seat) {
        this.name = name;
        this.specialNeeds = specialNeeds;
        this.luggage = luggage;
        this.flightClass = flightClass;
        this.seat = seat;

    }


    String getName() {
        return name;
    }

    boolean getSpecialNeeds() {
        return specialNeeds;
    }

    int getLuggage() {
        return luggage;
    }

    int getflightClass() {
        return flightClass;
    }

    String getSeat() {
        return seat;
    }

}
