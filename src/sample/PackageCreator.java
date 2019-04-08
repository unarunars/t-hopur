package sample;

import hopurd.models.Trip;
import leit.hotel.Hotel;

import java.util.ArrayList;

public class PackageCreator {
    Fetcher fetch = new Fetcher();
    ArrayList hotels = fetch.getAllHotels();
    ArrayList trips = fetch.getAllTrips();

    public Package pakkiEitt(){
        Package myPackage = new Package();
        Hotel hotel = (Hotel) hotels.get(2);
        Trip trip = (Trip) trips.get(4);
        myPackage.setName("Fjörpakkinn");
        myPackage.setDepartureDestination("Bíldudalur");
        myPackage.setDestination("Akureyri");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("BIU");
        myPackage.setDestinationID("AEY");
        myPackage.setDays(3);
        return myPackage;
    }
    public Package pakkiTvo(){
        Package myPackage = new Package();
        Hotel hotel = (Hotel) hotels.get(3);
        Trip trip = (Trip) trips.get(5);
        myPackage.setName("Klikkpakkinn");
        myPackage.setDepartureDestination("Árnanes");
        myPackage.setDestination("Akureyri");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("GJR");
        myPackage.setDestinationID("AEY");
        myPackage.setDays(2);
        return myPackage;
    }
    public Package pakkiThrju(){
        Package myPackage = new Package();
        Hotel hotel = (Hotel) hotels.get(4);
        Trip trip = (Trip) trips.get(2);
        myPackage.setName("Eyjabailpakkinn");
        myPackage.setDepartureDestination("Vestmanneyjar");
        myPackage.setDestination("Hornafjörður");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("VEY");
        myPackage.setDestinationID("HFN");
        myPackage.setDays(7);
        return myPackage;
    }
    public Package pakkiFjogur() {
        Package myPackage = new Package();
        Hotel hotel = (Hotel) hotels.get(1);
        Trip trip = (Trip) trips.get(1);
        myPackage.setName("Gjöróðipakkinn");
        myPackage.setDepartureDestination("Egilsstaðir");
        myPackage.setDestination("Árnanes");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("EGS");
        myPackage.setDestinationID("GJR");
        myPackage.setDays(14);
        return myPackage;
    }
    public Package pakkiFimm() {
        Package myPackage = new Package();
        Hotel hotel = (Hotel) hotels.get(0);
        Trip trip = (Trip) trips.get(8);
        myPackage.setName("Höfuðsvæðisbeilpakkinn");
        myPackage.setDepartureDestination("Reykjavík");
        myPackage.setDestination("Árnanes");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("RKV");
        myPackage.setDestinationID("GJR");
        myPackage.setDays(5);
        return myPackage;
    }

    public ArrayList pakkaSafn(){
        ArrayList pakkar = new ArrayList();
        pakkar.add(pakkiEitt());
        pakkar.add(pakkiTvo());
        pakkar.add(pakkiThrju());
        pakkar.add(pakkiFjogur());
        pakkar.add(pakkiFimm());

        return pakkar;
    }

}
