package leit.flug;

import java.io.FileWriter;
import java.io.IOException;

import main.java.com.cedarsoftware.util.io.JsonWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;


public class JSONFileWrite {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        int flightsPerDay = 10;
        int flightAmount = 20;

        String[] airports = {"AEY", "BIU", "EGS", "GJR", "GRY", "HFN", "HZK", "IFJ", "KEF", "RKV",
                "SAK", "THO", "VEY", "VPN"};

        String[] airportNames = {"Akureyri", "Bíldudalur", "Egilsstaðir", "Gjögur", "Grímsey", "Höfn",
                                "Húsavík", "Ísafjörður", "Keflavík", "Reykjavík", "Sauðárkrókur", "Þórshöfn",
                                "Vestmannaeyjar", "Vopnafjörður"};

        String[] dates = generateDates();

        JSONObject database = new JSONObject();
        Random r = new Random();
        JSONArray flights = new JSONArray();

        for(int i = 0; i < flightAmount; i++){
            int[] departArrive = uniqueRandom(14, 2);
            JSONObject flight = new JSONObject();
            flight.put("DepartureAirport", airports[departArrive[0]]);
            flight.put("ArrivalAirport", airports[departArrive[1]]);

            String[] times = generateTimes();
            flight.put("DepartureTime", times[0]);
            flight.put("ArrivalTime", times[1]);

            flight.put("Number", "FI" + (300 + i));
            flight.put("Price", 5000 + r.nextInt(10000));

            flights.add(flight);
        }

        JSONArray flightDates = new JSONArray();
        for(String date : dates) {

            if (date.equals("2019-1-1")) {
                JSONObject flightDate = new JSONObject();
                flightDate.put(date, new JSONArray());

                flightDates.add(flightDate);
            } else {
                JSONArray scheduledFlights = new JSONArray();
                int[] flightNumbers = uniqueRandom(flightAmount, flightsPerDay);

                for (int i = 0; i < flightNumbers.length; i++)
                    flightNumbers[i] += 300;

                for (int i = 0; i < flightsPerDay; i++) {
                    JSONObject scheduledFlight = new JSONObject();
                    scheduledFlight.put("Number", "FI" + flightNumbers[i]);
                    String seats = "";
                    int rowLength = Math.random() > 0.5 ? 4 : 6;
                    int rowAmount = 30 + r.nextInt(21);

                    for (int k = 0; k < rowLength * rowAmount; k++)
                        seats += "1";
                    scheduledFlight.put("AvailableSeats", seats);
                    scheduledFlight.put("RowLength", rowLength);
                    scheduledFlight.put("RowAmount", rowAmount);

                    JSONArray passengers = new JSONArray();

                    scheduledFlight.put("Passengers", passengers);

                    scheduledFlights.add(scheduledFlight);
                }

                JSONObject flightDate = new JSONObject();
                flightDate.put(date, scheduledFlights);

                flightDates.add(flightDate);
            }

        }
        database.put("ScheduledFlights", flightDates);
        database.put("Flights", flights);

        try (FileWriter file = new FileWriter("src/resources/Database.txt")) {
            file.write(JsonWriter.formatJson(database.toJSONString()));
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + database);
        }
    }


    private static String[] generateDates(){
        int year = 2019;
        String[] dates = new String[365];

        GregorianCalendar gc = new GregorianCalendar();

        gc.set(Calendar.YEAR, year);

        for(int i = 0; i < 365; i++) {
            gc.set(Calendar.DAY_OF_YEAR, i + 1);

            dates[i] = gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH);
        }

        return dates;
    }

    private static String[] generateTimes(){
        Random r = new Random();
        String[] times = new String[2];

        GregorianCalendar gc = new GregorianCalendar();
        int departHour = r.nextInt(20);
        gc.set(Calendar.HOUR_OF_DAY, departHour);
        gc.set(Calendar.MINUTE, r.nextInt(60));

        times[0] = gc.get(Calendar.HOUR_OF_DAY) + ":" + (gc.get(Calendar.MINUTE) + 1);

        gc.set(Calendar.HOUR_OF_DAY, departHour + 1 + r.nextInt(5));
        gc.set(Calendar.MINUTE, r.nextInt(60));

        times[1] = gc.get(Calendar.HOUR_OF_DAY) + ":" + (gc.get(Calendar.MINUTE));

        return times;
    }

    private static int[] uniqueRandom(int range, int amount) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] values = new int[amount];
        for (int i = 0; i < amount; i++) {
            values[i] = list.get(i);
        }

        return values;
    }
}