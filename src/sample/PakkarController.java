package sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    //ObservableList<String> pakkar = FXCollections.observableArrayList(fetch.getPackageNames(packages));
    @FXML
    private Label prufa;
    @FXML
    private DatePicker date;
    @FXML
    private TextField fjoldiGesta;
    @FXML
    private ChoiceBox veljaPakka;

    private String packName;

    //String packName = veljaPakka.getId();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTrips();
        Fetcher fetcher = new Fetcher();
        veljaPakka.setItems(pakkar);
        if( veljaPakka.getId() != null){
            System.out.println(veljaPakka.getSelectionModel());
        }


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
        ArrayList pakki = fetch.getPackageInfo(packages, 100000000,400000);
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
    private void BokaHandler(javafx.event.ActionEvent actionEvent) {
        int year = (date.getValue().getYear());
        int day = (date.getValue().getDayOfMonth());
        int month = (date.getValue().getMonthValue());

        String ar = Integer.toString(year);
        String dagur = Integer.toString(day);
        String manudur = Integer.toString(month);

        String dagsetning = ar + "-" +manudur + "-"+ dagur;
        Booking booking = new Booking();
        Fetcher fetcher = new Fetcher();
        System.out.println(veljaPakka.getValue().toString());
        Package pack = (Package) fetcher.getPackageByName(packages, packName);

        int fjoldi = Integer.parseInt(fjoldiGesta.getText());
        System.out.println(pack.getName());
        System.out.println("fjöldi gesta : " + fjoldi);
        System.out.println("date.getValur : " + date.getValue());
        System.out.println("pakki :  "+ packName);

        if (booking.bookPackage(dagsetning, fjoldi, pack) == true) {
            try {
                /*
                FXMLLoader loader = new FXMLLoader(getClass().getResource("boka.fxml"));
                Parent root = (Parent) loader.load();
                Stage stage = new Stage();
                stage.setTitle("Bóka");
                stage.setScene(new Scene(root));
                stage.show();
                */

                // Þetta er lausnin á að það poppi ekki alltaf upp nýr gluggi hvert skipti sem
                // ýtt er á takka til að ráfa um þetta forrit
                Parent adal_heim = FXMLLoader.load(getClass().getResource("boka.fxml"));
                Scene adal_scene = new Scene(adal_heim);
                Stage heim_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                heim_stage.setTitle("Bókaðu ferðina þína og skemmtu þér vel");
                heim_stage.setScene(adal_scene);
                heim_stage.show();

            } catch (Exception e) {
                System.out.println("villa: " + e.getMessage());
            }
        }/*
        else if( fjoldi == 0 && date.getValue() == null){
            try {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Fjöldi gesta og dagsetning vanntar");
                alert.setContentText("Vinsamlegast skráðu inn hvað mörg sæti þú villt fá í ferðina og dagsetningu");

                alert.showAndWait();
            } catch (Exception e){
                System.out.println("villa: " + e.getMessage());
            }

        }else if (0 == fjoldi){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Fjöldi gesta vanntar");
            alert.setContentText("Vinsamlegast skráðu inn hvað mörg sæti þú villt fá í ferðina");

            alert.showAndWait();
        }*/
        else{
            try{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Pakki sem þú valdir er ekki til");
                alert.setContentText("Vinsamlegast veldu pakka sem er í boði á dagsetningu sem þú valdir");

                alert.showAndWait();
            } catch (Exception e){
                System.out.println("villa: " + e.getMessage());
            }

        }


    }
    @FXML
    private void medalPakkarHandler(javafx.event.ActionEvent actionEvent){
        Fetcher fetch = new Fetcher();
        ArrayList pakki = fetch.getPackageInfo(packages, 400000,100000);
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

    @FXML
    public void veljaPakkaHandler(ActionEvent actionEvent) {
        packName = veljaPakka.getValue().toString();
        System.out.println(packName);
    }
}
