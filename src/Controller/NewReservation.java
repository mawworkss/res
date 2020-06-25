package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewReservation implements Initializable {

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

    @FXML
    private TextField visitorname;

    @FXML
    private TextField visitorsurname;

    @FXML
    private TextField visitoremail;

    @FXML
    private TextField visitorphone;

    @FXML
    private TextField checkin;

    @FXML
    private TextField checkout;

    @FXML
    private Pane listofreserv1;

    @FXML
    private ComboBox<String> roomselect;

    @FXML
    private Label info;

    @FXML
    private Button newreservationbutton1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader loader = new FXMLLoader();

        newreservationbutton1.setOnAction(event -> {
            try {
                DatabaseHandler.insertRecord(visitorname.getText(), visitorsurname.getText(), visitoremail.getText(),
                        visitorphone.getText(), checkin.getText(), checkout.getText(), roomselect.getEditor().getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
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
        historypage.setOnMouseClicked(event -> {
            mainpage.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/fxmlfiles/History.fxml"));
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

        roomselect.getItems().setAll("One Bed", "Two Beds", "Three Beds");

        info.textProperty().bind(roomselect.getSelectionModel().selectedItemProperty());
    }
}
