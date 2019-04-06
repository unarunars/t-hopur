package sample;

import leit.hotel.Hotel;
import leit.hotel.HotelsDAO;
import leit.hotel.searchActivity;

import java.util.ArrayList;

public class Main {

    public static void packages1(){
        Package myPackage = new Package();
        myPackage.setDestination("Akureyri");
        myPackage.setFlightDate("01.06.18");
        myPackage.setFlightSeats(20);
        myPackage.setHotel("Hótel Akureyri");
        myPackage.setHotelDate("01.06.18");
        myPackage.setHotelRooms(5);
        myPackage.setEvent("Bjórbað");
        myPackage.setEventDate("05.06.18");
        myPackage.setEventSeats(10);
        /*
        System.out.println("Fjörpakkinn");
        System.out.println("Áfangastaður: " + myPackage.getDestination());
        System.out.println("brottför: " + myPackage.getFlightDate());
        System.out.println("laus sæti í flugvél: " + myPackage.getFlightSeats());
        System.out.println("Hótel : " + myPackage.getHotel());
        System.out.println("Koma á hótel : " + myPackage.getHotelDate());
        System.out.println("Fjöldi lausra herbergja : " + myPackage.getHotelRooms());
        System.out.println("Dagsferð : " + myPackage.getEvent());
        System.out.println("Dagsetning á dagsferð : " + myPackage.getEventDate());
        System.out.println("Laus sæti í dagsferð : " + myPackage.getEventSeats());
        */

        searchActivity searchHotel = new searchActivity();


        //Hérna er sótt öll hótel
        HotelsDAO hotel = new HotelsDAO();
        ArrayList hotels = hotel.getAllHotels();
        Hotel singleHotel;
        for (int i = 0; i< hotels.size(); i++) {
            singleHotel = (Hotel) hotels.get(i);
            //Hérna geturu bætt við fetch t.d. singleHotel.getPrice()
            System.out.println(singleHotel.getName());
        }

        /*
        ArrayList north = hotel.hotelSearch("North region", 0, 100000);
        ArrayList west = hotel.hotelSearch("West region", 0, 100000);
        ArrayList south = hotel.hotelSearch("South region", 0, 100000);
        ArrayList east = hotel.hotelSearch("East region", 0, 100000);
        ArrayList rvk = hotel.hotelSearch("Capital area", 0, 100000);
        */
    }

    public static void main(String[] args) {
        
        Main.packages1();
    }

}
