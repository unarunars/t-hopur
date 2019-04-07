package sample;

public class PackageCreator {

    public Package pakkiEitt(String departureDate){
        Package myPackage = new Package();
        myPackage.setName("Fjörpakkinn");
        myPackage.setDestination("Akureyri");
        myPackage.setFlightDate("01.06.18");
        myPackage.setFlightSeats(20);
        myPackage.setHotel("Hótel Akureyri");
        myPackage.setHotelDate("01.06.18");
        myPackage.setHotelRooms(5);
        myPackage.setEvent("Bjórbað");
        myPackage.setEventDate("05.06.18");
        myPackage.setEventSeats(10);
        return myPackage;
    }
    public Package pakkiTvo(){
        Package myPackage = new Package();
        myPackage.setName("Ísafjarðarbeil");
        myPackage.setDestination("Reykjavík");
        myPackage.setFlightDate("01.06.18");
        myPackage.setFlightSeats(20);
        myPackage.setHotel("Hótel Akureyri");
        myPackage.setHotelDate("01.06.18");
        myPackage.setHotelRooms(5);
        myPackage.setEvent("Bjórbað");
        myPackage.setEventDate("05.06.18");
        myPackage.setEventSeats(10);
        return myPackage;
    }
}
