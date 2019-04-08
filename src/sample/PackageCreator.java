package sample;

import hopurd.models.Trip;
import leit.hotel.Hotel;

import java.util.ArrayList;

public class PackageCreator {
    Fetcher fetch = new Fetcher();
    ArrayList hotels = fetch.getAllHotels();
    ArrayList trips = fetch.getAllTrips();

    public Package pakki1(){
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
    public Package pakki2(){
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
    public Package pakki3(){
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
    public Package pakki4() {
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
    public Package pakki5() {
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

    public Package pakki6() {
        Package myPackage = new Package();
        Hotel hotel = (Hotel) hotels.get(6);
        Trip trip = (Trip) trips.get(10);
        myPackage.setName("PARTYPARTYPARTY");
        myPackage.setDepartureDestination("Reykjavík");
        myPackage.setDestination("Egilsstaðir");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("RKV");
        myPackage.setDestinationID("EGS");
        myPackage.setDays(3);
        return myPackage;
    }

    public Package pakki7() {
        Package myPackage = new Package();
        Hotel hotel = (Hotel) hotels.get(8);
        Trip trip = (Trip) trips.get(8);
        myPackage.setName("EKKI missa AF þessum!");
        myPackage.setDepartureDestination("Reykjavík");
        myPackage.setDestination("Egilsstaðir");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("GJR");
        myPackage.setDestinationID("AEY");
        myPackage.setDays(3);
        return myPackage;
    }

    public Package pakki8() {
        Package myPackage = new Package();
        Hotel hotel = (Hotel) hotels.get(8);
        Trip trip = (Trip) trips.get(1);
        myPackage.setName("Ástarferðin");
        myPackage.setDepartureDestination("Húsavík");
        myPackage.setDestination("Sauðárkrókur");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("HZK");
        myPackage.setDestinationID("SAK");
        myPackage.setDays(3);
        return myPackage;
    }

    public Package pakki9() {
        Package myPackage = new Package();
        Hotel hotel = (Hotel) hotels.get(4);
        Trip trip = (Trip) trips.get(8);
        myPackage.setName("Come fly with me");
        myPackage.setDepartureDestination("Hornafjörður");
        myPackage.setDestination("Grímsey");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("HFN");
        myPackage.setDestinationID("GRY");
        myPackage.setDays(6);
        return myPackage;
    }

    public Package pakki10() {
        Package myPackage = new Package();
        Hotel hotel = (Hotel) hotels.get(5);
        Trip trip = (Trip) trips.get(5);
        myPackage.setName("Fyrir alla nema pabba");
        myPackage.setDepartureDestination("Vopnafjörður");
        myPackage.setDestination("Keflavík");
        myPackage.setHotel(hotel);
        myPackage.setEvent(trip);
        myPackage.setDepartureDestinationID("VPN");
        myPackage.setDestinationID("KEF");
        myPackage.setDays(11);
        return myPackage;
    }

    public ArrayList pakkaSafn(){
        ArrayList pakkar = new ArrayList();
        pakkar.add(pakki1());
        pakkar.add(pakki2());
        pakkar.add(pakki3());
        pakkar.add(pakki4());
        pakkar.add(pakki5());
        pakkar.add(pakki6());
        pakkar.add(pakki7());
        pakkar.add(pakki8());
        pakkar.add(pakki9());
        pakkar.add(pakki10());

        return pakkar;
    }

}
