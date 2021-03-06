package sample;
import javafx.scene.Node;
import leit.flug.Schedule;
import leit.flug.ScheduledFlight;
import leit.flug.Flight;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import leit.flug.Flight;
import leit.hotel.Hotel;
import leit.hotel.HotelsDAO;
import leit.hotel.searchActivity;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Upprunalegi FXMLLoaderinn okkar
        /*
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        */

        // Þetta er lausnin á að það poppi ekki alltaf upp nýr gluggi hvert skipti sem
        // ýtt er á takka til að ráfa um þetta forrit
        Parent adal_heim = FXMLLoader.load(getClass().getResource("index.fxml"));
        Scene adal_scene = new Scene(adal_heim);
        //Stage heim_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Vá-Ferðir bjóða þér velkominn");
        stage.setScene(adal_scene);
        stage.show();

    }

    public static void packages1() {

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

    public static void packages2() {
        Fetcher fetch = new Fetcher();

        ArrayList hotelinfo = fetch.getAllFlights();
        for (int i = 0; i<hotelinfo.size(); i++) {
            Flight currFlight = (Flight) hotelinfo.get(i);
            System.out.print(currFlight.getDepartureAirport() + " to " + currFlight.getArrivalAirport() + "\n");
        }
    }

    public static void packages3() {
        Booking booking = new Booking();
        Fetcher fetch = new Fetcher();
        ArrayList packages = fetch.getAllPackages();
        Package testPackage = (Package) packages.get(1);
        boolean plz = booking.bookPackage("2019-1-3", 4, testPackage);
        System.out.println(plz);
    }

    public static void packages4() {
        Fetcher fetch = new Fetcher();
        ArrayList packages = fetch.getAllPackages();
        Package currPackage = fetch.getPackageByName(packages, "Gjöróðipakkinn");
        System.out.println(currPackage.getName());
    }

    public static void main(String[] args) {

        //packages4();
        //packages3();
        //packages2();
        //packages1();
        launch(args);
    }


}
