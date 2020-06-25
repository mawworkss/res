package Controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class History implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private Label mainpage;

    @FXML
    private Label newrespage;

    @FXML
    private Label roomspage;

    @FXML
    private Label respage;

    @FXML
    private Label visitorspage;

    @FXML
    private Label historypage;

    @FXML
    private Button newreservationbutton;

    @FXML
    private Label adminlabel;

    @FXML
    private Pane listofreserv;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader loader = new FXMLLoader();
        mainpage.setOnMouseClicked(event -> {
            mainpage.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/fxmlfiles/sample.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
        newreservationbutton.setOnMouseClicked(event -> {
            mainpage.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/fxmlfiles/NewReservation.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
        roomspage.setOnMouseClicked(event -> {
            mainpage.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/fxmlfiles/Rooms.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
        newrespage.setOnMouseClicked(event -> {
            mainpage.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/fxmlfiles/NewReservation.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
        visitorspage.setOnMouseClicked(event -> {
            mainpage.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/fxmlfiles/Visitors.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
        respage.setOnMouseClicked(event -> {
            mainpage.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/fxmlfiles/Reservations.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
    }
}
