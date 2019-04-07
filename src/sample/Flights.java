package sample;
import leit.flug.Schedule;
import leit.flug.ScheduledFlight;
import leit.flug.DatabaseManager;
import leit.flug.Flight;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Flights {

    public static void AllFlights() {
        Schedule lol = new Schedule();
        DatabaseManager hl = new DatabaseManager();


        //ScheduledFlight[] hello = lol.searchFlights("RKV", "GJR", "2019-1-3");
        //Flight realflight = hello[0].getFlight();
        //System.out.println(realflight.getTripPrice());

        Flight[] flights = hl.getFlights();

        //System.out.println(flights[30]);


        ScheduledFlight[] helleo = lol.searchFlightss();

        ScheduledFlight[] hlll = hl.getScheduledFlights();

        //int i;
        //for (i = 0; i < flights.length; i++) {
        //    System.out.println(flights[i]);
       // }
    }

    public static void AllPrufa() {
        JSONParser parser = new JSONParser();

        List<Flight> flightList = new ArrayList<>();

        try {
            Object obj = parser.parse(new FileReader("src/leit/flug/resources/Database.txt"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray flights = (JSONArray) jsonObject.get("Flights");
            for (int i = 0; i < flights.size(); i++) {
                JSONObject flightObj = (JSONObject) flights.get(i);
                System.out.print(flightObj.get("DepartureAirport")+(" til "));
                System.out.println(flightObj.get("ArrivalAirport"));

            }
        }
     catch (IOException | ParseException e) {
        e.printStackTrace();
    }
    }
    public static void main(String[] args) {

        Flights.AllFlights();
        Flights.AllPrufa();
    }
}
