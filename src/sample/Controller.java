package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {
    @FXML
    private Button hotelTakki;
    @FXML
    private Button pakkiTakki;
    @FXML
    private Button flugTakki;

     private HotelController hotel;
     private FlugController flug;
     private PakkarController pakki;




    @FXML
    private void hotelHandler(javafx.event.ActionEvent actionEvent){
        try {
            // Þetta er window/scene loaderinn sem var til staðar
            /*
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hotel.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Hótel");
            stage.setScene(new Scene(root));
            stage.show();
            */

            // Þetta er lausnin á að það poppi ekki alltaf upp nýr gluggi hvert skipti sem
            // ýtt er á takka til að ráfa um þetta forrit
            Parent adal_heim = FXMLLoader.load(getClass().getResource("hotel.fxml"));
            Scene adal_scene = new Scene(adal_heim);
            Stage heim_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            heim_stage.setTitle("Þetta eru hótelin sem eru í boði");
            heim_stage.setScene(adal_scene);
            heim_stage.show();

        } catch (Exception e) {
            System.out.println("villa: " + e.getMessage());
        }
    }

    
    @FXML
    private void pakkiHandler(javafx.event.ActionEvent actionEvent){
        try {
            // Þetta er window/scene loaderinn sem var til staðar
            /*
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pakkar.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Pakkar");
            stage.setScene(new Scene(root));
            stage.show();
            */

            // Þetta er lausnin á að það poppi ekki alltaf upp nýr gluggi hvert skipti sem
            // ýtt er á takka til að ráfa um þetta forrit
            Parent adal_heim = FXMLLoader.load(getClass().getResource("pakkar.fxml"));
            Scene adal_scene = new Scene(adal_heim);
            Stage heim_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            heim_stage.setTitle("Endilega veldu þér pakka sem hentar tilefninu");
            heim_stage.setScene(adal_scene);
            heim_stage.show();

        } catch (Exception e) {
            System.out.println("villa: " + e.getMessage());
        }
    }
    @FXML
    private void flugHandler(javafx.event.ActionEvent actionEvent){
        try {
            // Þetta er window/scene loaderinn sem var til staðar
            /*
            FXMLLoader loader = new FXMLLoader(getClass().getResource("flug.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Flug");
            stage.setScene(new Scene(root));
            stage.show();
            */

            // Þetta er lausnin á að það poppi ekki alltaf upp nýr gluggi hvert skipti sem
            // ýtt er á takka til að ráfa um þetta forrit
            Parent adal_heim = FXMLLoader.load(getClass().getResource("flug.fxml"));
            Scene adal_scene = new Scene(adal_heim);
            Stage heim_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            heim_stage.setTitle("Þessi flug eru í boða hjá okkur");
            heim_stage.setScene(adal_scene);
            heim_stage.show();

        } catch (Exception e) {
            System.out.println("villa: " + e.getMessage());
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hotelTakki.setTooltip(new Tooltip("hotel"));
        pakkiTakki.setTooltip(new Tooltip("pakkar"));
        flugTakki.setTooltip(new Tooltip("flug"));

    }


}
