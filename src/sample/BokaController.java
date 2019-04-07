package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pakkar.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Aðalsíða");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("villa: " + e.getMessage());
        }
    }
}
