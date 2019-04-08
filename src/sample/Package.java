package sample;

import hopurd.models.Trip;
import leit.hotel.Hotel;

public class Package {
    String name;
    String departureDestination;
    String departureDestinationID;
    String destination;
    String destinationID;
    int days;
    int totalPrice = 0;
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

    public void setDays(int dagar) { days = dagar; }
    public int getDays() { return days; }

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

    public int[] getPrice() {
        int[] price = new int[2];
        int currPrice = 0;
        Fetcher fetch = new Fetcher();
        currPrice += fetch.getFlightPrice(departureDestinationID, destinationID);
        currPrice += event.getPrice() * days;
        price[0] = currPrice;
        price[1] = fetch.getHotelPrice(hotel)*days;
        totalPrice = price[0] + price[1];
        return price;
    }

    public int getTotalPrice() {
        if (totalPrice == 0) getPrice();
        return totalPrice;
    }
}
