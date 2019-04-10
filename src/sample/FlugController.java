package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FlugController implements Initializable {

    @FXML
    private Label flugInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showFlights();
    }
    public void showFlights(){
        Fetcher fetch = new Fetcher();
        ArrayList flights = fetch.getFlightInfo();
        String r = "";
        for(int i = 0; i < flights.size(); i++){
            String a =  flights.get(i) + " \n ";
            r += a;
            if ( (i+1) % 4 == 0){
                r += "\n";
            }
        }
        System.out.println(r);
        flugInfo.setText(r);
    }

    @FXML
    private void  tilBakaHandler(javafx.event.ActionEvent actionEvent){
        try {
            // Þetta er window/scene loaderinn sem var til staðar
            /*
            FXMLLoader loader = new FXMLLoader(getClass().getResource("index.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Aðalsíða");
            stage.setScene(new Scene(root));
            stage.show();
            */

            // Þetta er lausnin á að það poppi ekki alltaf upp nýr gluggi hvert skipti sem
            // ýtt er á takka til að ráfa um þetta forrit
            Parent adal_heim = FXMLLoader.load(getClass().getResource("index.fxml"));
            Scene adal_scene = new Scene(adal_heim);
            Stage heim_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            heim_stage.setTitle("Aðalsíða VÁ-Ferða");
            heim_stage.setScene(adal_scene);
            heim_stage.show();

        } catch (Exception e) {
            System.out.println("villa: " + e.getMessage());
        }
    }
}
