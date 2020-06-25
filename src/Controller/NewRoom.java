package Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.security.mscapi.CPublicKey;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewRoom implements Initializable{

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
    private TextField room_number;

    @FXML
    private TextField description;

    @FXML
    private TextField price;

    private ToggleGroup group = new ToggleGroup();

    @FXML
    private RadioButton onebed;

    @FXML
    private RadioButton twobed;

    @FXML
    private RadioButton threebed;

    @FXML
    private CheckBox hasclean;

    @FXML
    private CheckBox haswifi;

    @FXML
    private CheckBox pets;

    @FXML
    private Button newreservationbutton1;

    @FXML
    private ComboBox<String > room_type;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onebed.setToggleGroup(group);
        onebed.setSelected(true);
        twobed.setToggleGroup(group);
        twobed.setSelected(true);
        threebed.setToggleGroup(group);
        threebed.setSelected(true);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(group.getSelectedToggle() != null){
                    RadioButton chk = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
                    System.out.println(chk.getText());
                }
            }
        });


        if(hasclean.isSelected()) hasclean.setSelected(true);
        else hasclean.setSelected(false);
        if(haswifi.isSelected()) haswifi.setSelected(true);
        haswifi.setSelected(false);
        if(pets.isSelected()) pets.setSelected(true);
        else pets.setSelected(false);
        FXMLLoader loader = new FXMLLoader();

        newreservationbutton1.setOnAction(event -> {
            try {
                DatabaseHandler.insertRoom(room_number.getText(), room_type.getEditor().getText(), price.getText(),
                        description.getText(), hasclean.getText(), haswifi.getText(), pets.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        room_type.getItems().setAll("ECONOMY", "NORMAL", "VIP");


        newreservationbutton.setOnAction(event -> {
            newreservationbutton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/fxmlfiles/NewReservation.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
        newrespage.setOnMouseClicked(event -> {
            newreservationbutton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/fxmlfiles/NewReservation.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
        roomspage.setOnMouseClicked(event -> {
            mainpage.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/fxmlfiles/NewRooms.fxml"));
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
    }
}
