package sample;

import java.util.ArrayList;

public class Package {
    String destination;
    String event;
    String hotel;
    ArrayList<String> flightDate = new ArrayList<String>();
    ArrayList<String> eventDate = new ArrayList<String>();
    ArrayList<String> hotelDate = new ArrayList<String>();
    int flightSeats;
    int hotelRooms;
    int eventSeats;

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

    public void setFlightDate(String date){
        flightDate.add(date);
    }
    public ArrayList<String> getFlightDate(){
        return flightDate;
    }

    public void setHotelDate(String date){
        hotelDate.add(date);
    }
    public ArrayList<String> getHotelDate(){
        return hotelDate;
    }

    public void setEventDate(String date){
        eventDate.add(date);
    }
    public ArrayList<String> getEventDate(){
        return eventDate;
    }

    public void setFlightSeats(int n){
        flightSeats = n;
    }
    public int getFlightSeats(){
        return flightSeats;
    }

    public void setHotelRooms(int n){
        hotelRooms = n;
    }
    public int getHotelRooms(){
        return hotelRooms;
    }

    public void setEventSeats(int n){
        eventSeats = n;
    }
    public int getEventSeats(){
        return eventSeats;
    }

    public void removeFlightSeats(int n) {
        int flightSize = flightDate.size();
        for (int i = 0; i < flightSize; i++) {
            System.out.println(flightDate.get(i) + " losaður, magn: " + n);
        }
    }
    public void removeHotelSeats(int n) {
        int hotelSize = hotelDate.size();
        for (int i = 0; i < hotelSize; i++) {
            System.out.println(hotelDate.get(i) + " losaður, magn: " + n);
        }
    }
    public void removeEventSeats(int n) {
        int eventSize = eventDate.size();
        for (int i = 0; i < eventSize; i++) {
            System.out.println(eventDate.get(i) + " losaður, magn: " + n);
        }
    }

}
