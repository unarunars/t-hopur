package sample;

import java.util.ArrayList;

public class Package {
    String name;
    String departureDestination;
    String destination;
    String event;
    String hotel;
    int flightSeats;
    int hotelRooms;
    int eventSeats;

    public void setName(String currName) { name = currName; }
    public String getName() { return name; }

    public void setDepartureDestination(String place) {
        departureDestination = place;
    }
    public String getDepartureDestination() { return departureDestination; }

    public void setDestination(String place){
        destination = place;
    }
    public String getDestination(){
        return destination;
    }

    public void setEvent(String thing){
        event = thing;
    }
    public String getEvent(){
        return event;
    }

    public void setHotel(String name){
        hotel = name;
    }
    public String getHotel(){
        return hotel;
    }

}
