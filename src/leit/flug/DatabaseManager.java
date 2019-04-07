package leit.flug;

import main.java.com.cedarsoftware.util.io.JsonWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    public static void main(String[] args){

    }

    public Flight[] getFlights(){
        JSONParser parser = new JSONParser();

        List<Flight> flightList = new ArrayList<>();

        try {
            Object obj = parser.parse(new FileReader("src/leit/flug/resources/Database.txt"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray flights = (JSONArray) jsonObject.get("Flights");
            for(int i = 0; i < flights.size(); i++){
                JSONObject flightObj = (JSONObject) flights.get(i);

                String NUMBER = (String) flightObj.get("Number");


                String DEPARTURE_AIRPORT =                   (String) flightObj.get("DepartureAirport");
                String ARRIVAL_AIRPORT =                     (String) flightObj.get("ArrivalAirport");
                String DEPARTURE_TIME =                      (String) flightObj.get("DepartureTime");
                String ARRIVAL_TIME =                        (String) flightObj.get("ArrivalTime");
                int TRIP_PRICE =                             Integer.parseInt(flightObj.get("Price").toString());

                Flight flight = new Flight(NUMBER, DEPARTURE_AIRPORT, ARRIVAL_AIRPORT,
                                            DEPARTURE_TIME, ARRIVAL_TIME, TRIP_PRICE);
                flightList.add(flight);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        Flight[] flights = new Flight[flightList.size()];

        for(int i = 0; i < flights.length; i++)
            flights[i] = flightList.get(i);

        return flights;
    }

    public void updateScheduledFlight(String date, String number, Booking booking){
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/leit/flug/resources/Database.txt"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray dates = (JSONArray) jsonObject.get("ScheduledFlights");
            JSONObject foundDate = new JSONObject();

            for(int i = 0; i < dates.size(); i++)
                if( ((JSONObject)dates.get(i)).containsKey(date) )
                    foundDate = (JSONObject) dates.get(i);

            JSONArray flights = (JSONArray) foundDate.get(date);

            JSONObject flight = new JSONObject();

            for(int i = 0; i < flights.size(); i++) {
                if (((JSONObject) flights.get(i)).containsValue(number)) {
                    flight = (JSONObject) flights.get(i);
                }
            }
            flights.remove(flight);


            String availableSeats = (String) flight.get("AvailableSeats");
            JSONArray passengers = (JSONArray) flight.get("Passengers");

            Passenger[] passengers1 = booking.getPassengers();
            for (int i = 0; i < passengers1.length-1; i++) {
                Passenger passenger = passengers1[i];
                JSONObject p = new JSONObject();
                p.put("Seat", passenger.getSeat());
                p.put("FlightClass", passenger.getflightClass());
                p.put("Luggage", passenger.getLuggage());
                p.put("Name", passenger.getName());
                p.put("SpecialNeeds", passenger.getSpecialNeeds());
                passengers.add(p);

                String seat = passenger.getSeat();
                String seatNumber = seat.replaceAll("^[A-I]", "");
                String seatLetter = seat.replaceAll("^[0-9]", "");

                int seatNo = Integer.parseInt(seatNumber);
                // Convert seatLetter to number, e.g. A=0
                char seatLetterChar = seatLetter.charAt(0);
                int seatLetterNo = seatLetterChar - 'A';

                StringBuilder newSeats = new StringBuilder(availableSeats);
                newSeats.setCharAt(seatNo * 5 + seatLetterNo, '0');
                availableSeats = newSeats.toString();
            }

            flight.put("Passengers", passengers);
            flight.put("AvailableSeats", availableSeats);
            flights.add(flight);
            dates.remove(foundDate);
            foundDate.put(date, flights);
            dates.add(foundDate);
            jsonObject.put("ScheduledFlights", dates);

            try (FileWriter file = new FileWriter("src/leit/flug/resources/Database.txt")) {
                file.write(JsonWriter.formatJson(jsonObject.toJSONString()));
                System.out.println("Successfully Copied JSON Object to File...");
                System.out.println("\nJSON Object: " + jsonObject);
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public ScheduledFlight[] getScheduledFlights(){
        JSONParser parser = new JSONParser();

        List<ScheduledFlight> scheduledFlightList = new ArrayList<>();

        Flight[] flights = getFlights();

        try {
            Object obj = parser.parse(new FileReader("src/leit/flug/resources/Database.txt"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray dates = (JSONArray) jsonObject.get("ScheduledFlights");
            for(int i = 0; i < dates.size(); i++){
                JSONObject dateObj = (JSONObject) dates.get(i);
                String date = (String) dateObj.keySet().toArray()[0];

                JSONArray dateArray = (JSONArray) dateObj.get(dateObj.keySet().toArray()[0]);

                for(int j = 0; j < dateArray.size(); j++){
                    JSONObject scheduledFlightObj = (JSONObject) dateArray.get(j);
                    int rowAmount = Integer.parseInt(scheduledFlightObj.get("RowAmount").toString());
                    int rowLength = Integer.parseInt(scheduledFlightObj.get("RowLength").toString());
                    String number = scheduledFlightObj.get("Number").toString();
                    String availableSeats = scheduledFlightObj.get("AvailableSeats").toString();

                    Flight tiedFlight = null;

                    for(Flight flight : flights){
                        if(flight.getNumber().equals(number)) {
                            tiedFlight = flight;
                            break;
                        }
                    }

                    ScheduledFlight sf = new ScheduledFlight(date, rowAmount, rowLength, tiedFlight, availableSeats);

                    scheduledFlightList.add(sf);
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        ScheduledFlight[] scheduledFlights = new ScheduledFlight[scheduledFlightList.size()];

        for(int i = 0; i < scheduledFlights.length; i++)
            scheduledFlights[i] = scheduledFlightList.get(i);

        return scheduledFlights;
    }

}
