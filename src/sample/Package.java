package sample;

public class Package {
    String name;
    String departureDestination;
    String departureDestinationID;
    String destination;
    String destinationID;
    String event;
    String hotel;

    public void setName(String currName) { name = currName; }
    public String getName() { return name; }

    public void setDepartureDestination(String place) { departureDestination = place; }
    public String getDepartureDestination() { return departureDestination; }

    public void setDestination(String place){ destination = place; }
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
