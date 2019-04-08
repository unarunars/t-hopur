package sample;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import leit.flug.Schedule;
import leit.flug.ScheduledFlight;
import leit.flug.DatabaseManager;
import leit.flug.Flight;
import leit.hotel.HotelsDAO;
import leit.hotel.Hotel;
import leit.hotel.Room;

import java.util.ArrayList;

public class Fetcher {

    public ArrayList getAllHotels() {
        HotelsDAO hotel = new HotelsDAO();
        ArrayList hotels = hotel.getAllHotels();
        return hotels;
    }

    public ArrayList getHotelInfo() {
        ArrayList hotels = getAllHotels();
        ArrayList hotelInfo = new ArrayList();
        Hotel currHotel;
        for (int i = 0; i<hotels.size();i++) {
            currHotel = (Hotel) hotels.get(i);
            hotelInfo.add(currHotel.getName());
            hotelInfo.add(currHotel.getHotelAddress());
            hotelInfo.add(currHotel.getHotelInfo());
        }
        return hotelInfo;
    }


    public ArrayList getAllScheduledFlights() {
        Schedule schedule = new Schedule();
        ScheduledFlight[] flights = schedule.getAllFlights();
        ArrayList realFlights = new ArrayList();
        for (int i = 0; i< flights.length; i++) {
            realFlights.add(flights[i]);
        }
        return realFlights;
    }

    public ArrayList getAllFlights() {
        DatabaseManager dm = new DatabaseManager();
        Flight[] flights = dm.getFlights();
        ArrayList realFlights = new ArrayList<>();
        for (int i = 0; i<flights.length; i++) {
            realFlights.add(flights[i]);
        }
        return realFlights;
    }

    public ArrayList getFlightInfo() {
        ArrayList flights = getAllFlights();
        ArrayList flightInfo = new ArrayList();
        Flight currFlight;
        for (int i = 0; i<flights.size();i++) {
            currFlight = (Flight) flights.get(i);
            flightInfo.add("Flugnúmer er " + currFlight.getNumber());
            flightInfo.add("Frá flugvelli " + currFlight.getDepartureAirport());
            flightInfo.add(" til flugvölls " + currFlight.getArrivalAirport());
            flightInfo.add("Verð: " + currFlight.getTripPrice());
        }
        return flightInfo;
    }

    public int getFlightPrice(String destID, String departID) {
        int price = 0;
        ArrayList flights = getAllFlights();
        Flight currFlight = null;
        for (int i = 0; i<flights.size(); i++) {
            currFlight = (Flight) flights.get(i);
            if (currFlight.getArrivalAirport() == destID) {
                if (currFlight.getDepartureAirport() == departID) {
                    break;
                }
            }
        }
        price += currFlight.getTripPrice();
        return price;
    }

    public int getHotelPrice(Hotel hotel) {
        ArrayList rooms = hotel.getRooms();
        Room room = null;
        int price = 0;
        for (int i = 0; i<rooms.size();i++) {
            room = (Room) rooms.get(i);
            price += room.getPrice();
        }
        return price;
    }

    public ArrayList getAllTrips() {
        hopurd.main.API.initDB();
        ArrayList trips = hopurd.main.API.getAllTrips();
        return trips;
    }

    public ArrayList getAllPackages() {
        PackageCreator creator = new PackageCreator();
        ArrayList packages = creator.pakkaSafn();

        return packages;
    }

    public ArrayList getPackageInfo() {
        ArrayList packages = getAllPackages();
        ArrayList packageInfo = new ArrayList();
        Package currPackage;
        for (int i = 0; i<packages.size(); i++) {
            currPackage = (Package) packages.get(i);
            packageInfo.add(currPackage.getName());
            packageInfo.add(currPackage.getDepartureDestination());
            packageInfo.add(currPackage.getDestination());
            //packageInfo.add(currPackage.getHotel().getName());
            //packageInfo.add(currPackage.getEvent().getName());
            //packageInfo.add(currPackage.getPrice(14));
        }
        return packageInfo;
    }
}
