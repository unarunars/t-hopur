package sample;

public class Package {
   String destination = "";
   String event = "";
   String hotel = "";
   String flightDate = "";
   String eventDate = "";
   String hotelDate = "";
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
       flightDate = date;
   }
   public String getFlightDate(){
       return flightDate;
   }
    public void setHotelDate(String date){
       hotelDate = date;
    }
    public String getHotelDate(){
       return hotelDate;
    }
    public void setEventDate(String date){
       eventDate = date;
    }
    public String getEventDate(){
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
}
