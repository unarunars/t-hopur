package sample;

import hopurd.models.Trip;
import leit.hotel.Hotel;

import java.util.ArrayList;

public class PackageCreator {

    public Package pakkiEitt(){
        Fetcher fetch = new Fetcher();
        ArrayList hotels = fetch.getAllHotels();
        ArrayList trips = fetch.getAllTrips();
        Hotel hotel = (Hotel) hotels.get(2);
        Trip trip = (Trip) trips.get(4);
        Package myPackage = new Package();
        myPackage.setName("Fjörpakkinn");
        myPackage.setDepartureDestination("Bíldudalur");
        myPackage.setDestination("Akureyri");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("BIU");
        myPackage.setDestinationID("AEY");
        return myPackage;
    }
    public Package pakkiTvo(){
        Package myPackage = new Package();
        Fetcher fetch = new Fetcher();
        ArrayList hotels = fetch.getAllHotels();
        ArrayList trips = fetch.getAllTrips();
        Hotel hotel = (Hotel) hotels.get(3);
        Trip trip = (Trip) trips.get(5);
        myPackage.setName("Klikkpakkinn");
        myPackage.setDepartureDestination("Árnanes");
        myPackage.setDestination("Akureyri");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("GJR");
        myPackage.setDestinationID("AEY");
        return myPackage;
    }
    public Package pakkiThrju(){
        Fetcher fetch = new Fetcher();
        ArrayList hotels = fetch.getAllHotels();
        ArrayList trips = fetch.getAllTrips();
        Hotel hotel = (Hotel) hotels.get(4);
        Trip trip = (Trip) trips.get(2);
        Package myPackage = new Package();
        myPackage.setName("Eyjabailpakkinn");
        myPackage.setDepartureDestination("Vestmanneyjar");
        myPackage.setDestination("Hornafjörður");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("VEY");
        myPackage.setDestinationID("HFN");
        return myPackage;
    }
    public Package pakkiFjogur() {
        Fetcher fetch = new Fetcher();
        ArrayList hotels = fetch.getAllHotels();
        ArrayList trips = fetch.getAllTrips();
        Hotel hotel = (Hotel) hotels.get(1);
        Trip trip = (Trip) trips.get(1);
        Package myPackage = new Package();
        myPackage.setName("Gjöróðipakkinn");
        myPackage.setDepartureDestination("Egilsstaðir");
        myPackage.setDestination("Árnanes");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("EGS");
        myPackage.setDestinationID("GJR");
        return myPackage;
    }
    public Package pakkiFimm() {
        Fetcher fetch = new Fetcher();
        ArrayList hotels = fetch.getAllHotels();
        ArrayList trips = fetch.getAllTrips();
        Hotel hotel = (Hotel) hotels.get(0);
        Trip trip = (Trip) trips.get(8);
        Package myPackage = new Package();
        myPackage.setName("Höfuðsvæðisbeilpakkinn");
        myPackage.setDepartureDestination("Reykjavík");
        myPackage.setDestination("Árnanes");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("RKV");
        myPackage.setDestinationID("GJR");
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
