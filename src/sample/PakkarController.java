package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;

import java.util.Observable;
import java.util.ResourceBundle;


public class PakkarController implements Initializable {
    Fetcher fetch = new Fetcher();
    ArrayList packages = fetch.getAllPackages();

    ObservableList<String> pakkar = FXCollections.observableArrayList("Fjörpakkinn", "Klikkpakinn", "Eyjapakkinn", "Gjöróðipakkinn", "Höfuðsvæðisbeilpakkinn", "PARTYPARTYPARTY", "EKKI missa AF þessum!", "Ástarferðin", "Come fly with me", "Fyrir alla nema pabba");

    @FXML
    private Label prufa;
    @FXML
    private DatePicker date;
    @FXML
    private TextField fjoldiGesta;
    @FXML
    private ChoiceBox veljaPakka;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTrips();
        veljaPakka.setItems(pakkar);

    }
    public void showTrips(){
        Fetcher fetch = new Fetcher();
        ArrayList flights = fetch.getPackageInfo(packages, 0,0);
        String r = "";
        for(int i = 0; i < flights.size(); i++){
            String a =  flights.get(i) + " \n ";
            r += a;
            if ( (i+1) % 10 == 0){
                r += "\n";
            }
        }
        prufa.setText(r);
    }
    @FXML
    private void luxusPakkiHandler(javafx.event.ActionEvent actionEvent){
        Fetcher fetch = new Fetcher();
        ArrayList pakki = fetch.getPackageInfo(packages, 500000,300000);
        String r = "";
        for(int i = 0; i < pakki.size(); i++){
            String a =  pakki.get(i) + " \n ";
            r += a;
            if ( (i+1) % 10 == 0){
                r += "\n";
            }
        }
        prufa.setText(r);

    }
    @FXML
    private void BokaHandler(javafx.event.ActionEvent actionEvent){
        int year = (date.getValue().getYear());
        int day = (date.getValue().getDayOfMonth());
        int month = (date.getValue().getMonthValue());

        String ar = Integer.toString(year);
        String dagur= Integer.toString(day);
        String manudur = Integer.toString(month);

        String dagsetning = ar + "-" + manudur + "-" + dagur;
        Booking booking = new Booking();
        Fetcher fetcher = new Fetcher();

        Package pack = fetcher.getPackageByName(packages, "Fjörpakkinn");

        int a = Integer.parseInt(fjoldiGesta.getText());

        if(booking.bookPackage(dagsetning, a, pack)){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("boka.fxml"));
                Parent root = (Parent) loader.load();
                Stage stage = new Stage();
                stage.setTitle("Bóka");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                System.out.println("villa: " + e.getMessage());
            }
        }else if(null == fjoldiGesta && date.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Fjöldi gesta og dagsetning vanntar");
            alert.setContentText("Vinsamlegast skráðu inn hvað mörg sæti þú villt fá í ferðina og dagsetningu");

            alert.showAndWait();
        }else if (null == fjoldiGesta){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Fjöldi gesta vanntar");
            alert.setContentText("Vinsamlegast skráðu inn hvað mörg sæti þú villt fá í ferðina");

            alert.showAndWait();
        }else if (date.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Dagsetning vanntar");
            alert.setContentText("Vinsamlegast veldu dagsetningu");

            alert.showAndWait();
        }

    }
    @FXML
    private void medalPakkarHandler(javafx.event.ActionEvent actionEvent){
        Fetcher fetch = new Fetcher();
        ArrayList pakki = fetch.getPackageInfo(packages, 300000,100000);
        String r = "";
        for(int i = 0; i < pakki.size(); i++){
            String a =  pakki.get(i) + " \n ";
            r += a;
            if ( (i+1) % 10 == 0){
                r += "\n";
            }
        }
        prufa.setText(r);

    }
    @FXML
    private void lagPakkaHandler(javafx.event.ActionEvent actionEvent){
        Fetcher fetch = new Fetcher();
        ArrayList pakki = fetch.getPackageInfo(packages, 100000,0);
        String r = "";
        for(int i = 0; i < pakki.size(); i++){
            String a =  pakki.get(i) + " \n ";
            r += a;
            if ( (i+1) % 10 == 0){
                r += "\n";
            }
        }
        prufa.setText(r);

    }
    @FXML
    private void dateFilterHandler(){
        int year = (date.getValue().getYear());
        int day = (date.getValue().getDayOfMonth());
        int month = (date.getValue().getMonthValue());

        String ar = Integer.toString(year);
        String dagur= Integer.toString(day);
        String manudur = Integer.toString(month);

        String dagsetning = ar + "-" + manudur + "-" + dagur;

        System.out.println("ár: "+ year);
        System.out.println("day: "+ day);
        System.out.println("mánuður : "+ month);
        System.out.println(dagsetning);

        Fetcher fetch = new Fetcher();
        ArrayList pakki = fetch.getPackageDateInfo(packages, 0,0, dagsetning);
        String r = "";
        for(int i = 0; i < pakki.size(); i++){
            String a =  pakki.get(i) + " \n ";
            r += a;
            if ( (i+1) % 10 == 0){
                r += "\n";
            }
        }
        prufa.setText(r);
    }

    @FXML
    private void  tilBakaHandler(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("index.fxml"));
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
