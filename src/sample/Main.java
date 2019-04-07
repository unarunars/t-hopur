package sample;
import leit.flug.Schedule;
import leit.flug.ScheduledFlight;
import leit.flug.Flight;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import leit.hotel.Hotel;
import leit.hotel.HotelsDAO;
import leit.hotel.searchActivity;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void packages1() {

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
        for (int i = 0; i < hotels.size(); i++) {
            singleHotel = (Hotel) hotels.get(i);
            //Hérna geturu bætt við fetch t.d. singleHotel.getPrice()
            System.out.println(singleHotel.getName());
            System.out.println(hotel.getRoomsInHotel(singleHotel.getHotelID()).get(0));
        }

        hopurd.main.API.initDB();

        ArrayList bookings = hopurd.main.API.getAllBookings();
        ArrayList daytrips = hopurd.main.API.getAllTrips();
        for (int i = 0; i<bookings.size();i++) {
            System.out.println(bookings.get(i));
        }
        for (int i = 0; i<daytrips.size();i++) {
            System.out.println(daytrips.get(i));
        }
    }

    public static void packages2(){
        Fetcher fetch = new Fetcher();

        ArrayList flights = fetch.getAllFlights();
        ArrayList hotels = fetch.getAllHotels();
        ArrayList trips = fetch.getAllTrips();

        System.out.println(flights);
        System.out.println(hotels);
        System.out.println(trips);
    }

    public static void main(String[] args) {

        packages2();
        //packages1();
        //launch(args);
    }


}
