package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;


public class PakkarController implements Initializable {
    Fetcher fetch = new Fetcher();
    ArrayList packages = fetch.getAllPackages();

    /*
    Package soldPackage = (Package) packages.get(4);
    String testName = soldPackage.getName();
    */

    @FXML
    private Label prufa;
    @FXML
    private DatePicker date;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTrips();

    }
    public void showTrips(){
        Fetcher fetch = new Fetcher();
        ArrayList flights = fetch.getPackageInfo(packages, 0,0);
        String r = "";
        for(int i = 0; i < flights.size(); i++){
            String a =  flights.get(i) + " \n ";
            r += a;
            if ( (i+1) % 9 == 0){
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
            if ( (i+1) % 9 == 0){
                r += "\n";
            }
        }
        prufa.setText(r);

    }
    @FXML
    private void medalPakkarHandler(javafx.event.ActionEvent actionEvent){
        Fetcher fetch = new Fetcher();
        ArrayList pakki = fetch.getPackageInfo(packages, 300000,100000);
        String r = "";
        for(int i = 0; i < pakki.size(); i++){
            String a =  pakki.get(i) + " \n ";
            r += a;
            if ( (i+1) % 9 == 0){
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
            if ( (i+1) % 9 == 0){
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
            if ( (i+1) % 9 == 0){
                r += "\n";
            }
        }
        prufa.setText(r);
    }
    @FXML
    private void BokaHandler(javafx.event.ActionEvent actionEvent){
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
