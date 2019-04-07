package sample;

import hopurd.models.Trip;
import leit.hotel.Hotel;

public class Package {
    String name;
    String departureDestination;
    String departureDestinationID;
    String destination;
    String destinationID;
    Trip event;
    Hotel hotel;

    public void setName(String currName) { name = currName; }
    public String getName() { return name; }

    public void setDepartureDestination(String place) { departureDestination = place; }
    public String getDepartureDestination() { return departureDestination; }

    public void setDepartureDestinationID(String place) { departureDestinationID = place; }
    public String getDepartureDestinationID() { return departureDestinationID; }

    public void setDestination(String place){ destination = place; }
    public String getDestination(){
        return destination;
    }

    public void setDestinationID(String place){ destinationID = place; }
    public String getDestinationID(){
        return destinationID;
    }

    public void setEvent(Trip thing){
        event = thing;
    }
    public Trip getEvent(){
        return event;
    }

    public void setHotel(Hotel name){
        hotel = name;
    }
    public Hotel getHotel(){
        return hotel;
    }

    public int[] getPrice(int days) {
        int[] price = new int[2];
        int currPrice = 0;
        Fetcher fetch = new Fetcher();
        currPrice += fetch.getFlightPrice(departureDestinationID, destinationID);
        currPrice += event.getPrice();
        price[0] = currPrice;
        price[1] = currPrice + fetch.getHotelPrice(hotel)*days;
        return price;
    }
}
