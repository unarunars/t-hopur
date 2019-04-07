package leit.flug;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

import java.time.LocalDate;
import java.util.Arrays;


public class FlightController {

    @FXML
    private ChoiceBox<Integer> noPassHandler;

    @FXML
    private Button searchHandler;

    @FXML
    private ListView<ScheduledFlight> flightListHandler;

    @FXML
    private DatePicker dateHandler;

    @FXML
    private ChoiceBox<String> depHandler;

    @FXML
    private ComboBox<String> arrHandler;

    private BookingController bookingController;


    @FXML
    void initialize(){
        bookingController = new BookingController();

        bookingController.createBooking();

        ObservableList<Integer> flights = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        noPassHandler.setItems(flights);
        noPassHandler.setValue(1);

        String[] airports = {"AEY", "BIU", "EGS", "GJR", "GRY", "HFN", "HZK", "IFJ", "KEF", "RKV",
                "SAK", "THO", "VEY", "VPN"};

        String[] airportNames = {"Akureyri", "Bíldudalur", "Egilsstaðir", "Gjögur", "Grímsey", "Höfn",
                "Húsavík", "Ísafjörður", "Keflavík", "Reykjavík", "Sauðárkrókur", "Þórshöfn",
                "Vestmannaeyjar", "Vopnafjörður"};
        ObservableList<String> airportList = FXCollections.observableArrayList();
        for(int i = 0; i < airports.length; i++){
            airportList.add(airports[i] + " - " + airportNames[i]);
        }

        depHandler.setItems(airportList);
        arrHandler.setItems(airportList);

        depHandler.setValue(airportList.get(0));
        arrHandler.setValue(airportList.get(1));

        searchHandler.setOnMouseClicked(event -> {
            LocalDate localDate = dateHandler.getValue();
            int month = localDate.getMonth().getValue();
            int day = localDate.getDayOfMonth();
            int year = localDate.getYear();

            String departure = depHandler.getValue().split(" ")[0];
            String arrival = arrHandler.getValue().split(" ")[0];
            int passengerAmount = noPassHandler.getValue();
            ScheduledFlight[] foundFlights = bookingController.searchFlights(departure, arrival, year + "-" + month + "-" + day, passengerAmount);


            ObservableList<ScheduledFlight> flightList = FXCollections.observableArrayList();

            flightList.addAll(Arrays.asList(foundFlights));

            flightListHandler.setItems(flightList);
        } );

        flightListHandler.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2){
                bookingController.pickFlight(flightListHandler.getSelectionModel().getSelectedItem());
            }
        });
    }
}

