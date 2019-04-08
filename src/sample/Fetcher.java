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
            flightInfo.add("Til flugvölls " + currFlight.getArrivalAirport());
            flightInfo.add("Verð: " + currFlight.getTripPrice() + " kr.");
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
        price /= rooms.size();
        return price;
    }

    public int[] getHotelRoomsSize(Hotel hotel) {
        ArrayList rooms = hotel.getRooms();
        Room room = null;
        int[] sizes = new int[2];
        sizes[0] = 99999;
        sizes[1] = -9999;
        for (int i = 0; i < rooms.size(); i++) {
            room = (Room) rooms.get(i);
            if (room.getGuests() < sizes[0]) sizes[0] = room.getGuests();
            if (room.getGuests() > sizes[1]) sizes[1] = room.getGuests();
        }
        return sizes;
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

    public ArrayList getPackageDateInfo(ArrayList packages, int filterMax, int filterMin, String date) {
        Schedule schedule = new Schedule();
        ArrayList newPackages = new ArrayList();
        Package currPackage = null;
        for (int i = 0; i<packages.size(); i++) {
            currPackage = (Package) packages.get(i);
            ScheduledFlight[] flights = schedule.searchFlights( currPackage.getDepartureDestinationID(),
                                                                currPackage.getDestinationID(),
                                                                date);
            if (flights.length == 0) {
                continue;
            } else {
                newPackages.add(currPackage);
            }
        }
        return getPackageInfo(newPackages, filterMin, filterMax);
    }

    public ArrayList getPackageInfo(ArrayList packages, int filterMax, int filterMin) {
        if (filterMax == 0) filterMax = 999999999;
        ArrayList packageInfo = new ArrayList();
        Package currPackage = null;
        int[] price; int[] sizes;
        for (int i = 0; i<packages.size(); i++) {
            currPackage = (Package) packages.get(i);
            price = currPackage.getPrice();
            if ((currPackage.getTotalPrice() < filterMax) && (currPackage.getTotalPrice() > filterMin)) {
                sizes = getHotelRoomsSize(currPackage.getHotel());
                packageInfo.add(currPackage.getName());
                packageInfo.add("Frá " + currPackage.getDepartureDestination());
                packageInfo.add("Til " + currPackage.getDestination());
                packageInfo.add("Hótel: " + currPackage.getHotel().getName());
                packageInfo.add("Viðburður: " + currPackage.getEvent().getName());
                packageInfo.add("Flug og viðburðarkostnaður fyrir einstakling: " + price[0] + " kr.");
                packageInfo.add("Meðal gistingarkostnaður herbergis: " + price[1] + " kr.");
                packageInfo.add("Meðal samtalskostnaður: " + currPackage.getTotalPrice() + " kr.");
                packageInfo.add("Herbergi geta haldið um " + sizes[0] + " til " + sizes[1] + " gesti");
            }
        }
        return packageInfo;
    }

}
