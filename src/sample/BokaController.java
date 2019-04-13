package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;


public class BokaController implements Initializable {

    public TextField nafn;
    public TextField netfang;
    public TextField card;
    public TextField cvc;
    public  boolean value = true;

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
    private void StadfestaHandler(ActionEvent actionEvent) throws IOException {
        // Boolean gildi sem hálpar mér að velja milli villuglugga og bókunarstaðferstingu
        value = true;

            // If fall fyrir Villugluggan
            if (isString(nafn, nafn.getText()) == false || isString(netfang, netfang.getText()) == false
                    || isInt(card,card.getText()) == false || isInt(cvc,cvc.getText()) == false) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Upp kom villa");
                alert.setHeaderText(null);
                alert.setContentText("Vinsamlegast fylltu í reitina viðeigandi upplýsingar");

                alert.showAndWait();
            }
            // If fall fyrir Bókunarstaðfestingu
            if (isInt(card,card.getText()) == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Góða ferð!");
                alert.setHeaderText(null);
                alert.setContentText("Þú hefur staðfest pakkann");
                alert.showAndWait();

                // Förum aftur á aðalsíðu
                Parent adal_heim = FXMLLoader.load(getClass().getResource("index.fxml"));
                Scene adal_scene = new Scene(adal_heim);
                Stage heim_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                heim_stage.setTitle("Velkomin/n á Aðalsíðu");
                heim_stage.setScene(adal_scene);
                heim_stage.show();

        }
    }

    // Hjálparfall til að athuga hvort um sé tölustafi að ræða
    private boolean isInt(TextField input,String message){
        try {
            BigInteger text = (BigInteger) BigInteger.valueOf(Long.parseLong(input.getText()));
            // System.out.println(text);
            return value;
        }catch (NumberFormatException e){
            value = false;
            // System.out.println("Upp kom Villa");
            return value;
        }
    }

    // Hjálparfall sem athugar hvort við séum með streng
    private boolean isString(TextField input,String message){
        try {
            int text = Integer.parseInt(input.getText());
            // System.out.println("Upp koma villa");
            value = false;
            return value;
        }catch (NumberFormatException e){
            // System.out.println(input.getText());
            return value;
        }
    }
}
