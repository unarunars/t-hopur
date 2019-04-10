package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BokaController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML
    private void  TilBakaHandler(javafx.event.ActionEvent actionEvent) {
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
            heim_stage.setTitle("Endilega veldu þér pakka");
            heim_stage.setScene(adal_scene);
            heim_stage.show();

        } catch (Exception e) {
            System.out.println("villa: " + e.getMessage());
        }
    }
    @FXML
    private void StadfestaHandler(javafx.event.ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Góða ferð!");
        alert.setHeaderText(null);
        alert.setContentText("Þú hefur staðfest pakkann");

        alert.showAndWait();
    }
}
