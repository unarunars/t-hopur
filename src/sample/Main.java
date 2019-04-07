package sample;
import leit.flug.Schedule;
import leit.flug.ScheduledFlight;
import leit.flug.Flight;

import java.util.ArrayList;

public class Main {

    public static void packages1(){

        Package myPackage = new Package();

        //System.out.println(hello[0]);
        //System.out.println(hello[1]);

        myPackage.setDestination("Akureyri");
        myPackage.setFlightDate("01.06.18");
        myPackage.setFlightSeats(20);
        myPackage.setHotel("Hótel Akureyri");
        myPackage.setHotelDate("01.06.18");
        myPackage.setHotelRooms(5);
        myPackage.setEvent("Bjórbað");
        myPackage.setEventDate("05.06.18");
        myPackage.setEventSeats(10);
        //System.out.println("Fjörpakkinn");
        //System.out.println("Áfangastaður: " + myPackage.getDestination());
        //System.out.println("brottför: " + myPackage.getFlightDate());
        //System.out.println("laus sæti í flugvél: " + myPackage.getFlightSeats());
        //System.out.println("Hótel : " + myPackage.getHotel());
        //System.out.println("Koma á hótel : " + myPackage.getHotelDate());
        //System.out.println("Fjöldi lausra herbergja : " + myPackage.getHotelRooms());
        //System.out.println("Dagsferð : " + myPackage.getEvent());
        //System.out.println("Dagsetning á dagsferð : " + myPackage.getEventDate());
        //System.out.println("Laus sæti í dagsferð : " + myPackage.getEventSeats());
    }

    public static void main(String[] args) {
        
        Main.packages1();
    }

}
