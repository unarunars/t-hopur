package leit.flug;

public class Flight {
    private String NUMBER;
    private String DEPARTURE_AIRPORT;
    private String ARRIVAL_AIRPORT;
    private String DEPARTURE_TIME;
    private String ARRIVAL_TIME;
    private int TRIP_PRICE;

    public Flight(String NUMBER,
                  String DEPARTURE_AIRPORT,
                  String ARRIVAL_AIRPORT,
                  String DEPARTURE_TIME,
                  String ARRIVAL_TIME,
                  int TRIP_PRICE) {

        this.NUMBER = NUMBER;
        this.DEPARTURE_AIRPORT = DEPARTURE_AIRPORT;
        this.ARRIVAL_AIRPORT = ARRIVAL_AIRPORT;
        this.DEPARTURE_AIRPORT = DEPARTURE_AIRPORT;
        this.DEPARTURE_TIME = DEPARTURE_TIME;
        this.ARRIVAL_TIME = ARRIVAL_TIME;
        this.TRIP_PRICE = TRIP_PRICE;

    }

    String getNumber() {
        return NUMBER;
    }

    String getDepartureAirport() {
        return DEPARTURE_AIRPORT;
    }

    String getArrivalAirport() {
        return ARRIVAL_AIRPORT;
    }

    String getDepartureTime() {
        return DEPARTURE_TIME;
    }

    String getArrivalTime() {
        return ARRIVAL_TIME;
    }

    int getTripPrice() {
        return TRIP_PRICE;
    }

    /*
    @Override
    public String toString(){
        return getNumber();
    }
    */
}
