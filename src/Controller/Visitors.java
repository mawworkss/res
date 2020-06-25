package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Visitors implements Initializable {

    @FXML
    private AnchorPane anchorpane;

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
    private Label rooms;

    @FXML
    private Pane listofreserv;

    @FXML
    private TableView<VisitorsTable> visitorstable;

    @FXML
    private TableColumn id = new TableColumn();

    @FXML
    private TableColumn fullname = new TableColumn();

    @FXML
    private TableColumn email = new TableColumn();

    @FXML
    private TableColumn phone = new TableColumn();

    @FXML
    private TableColumn room = new TableColumn();

    @FXML
    private TableColumn createdat = new TableColumn();

    private String SELECT_QUERY = "SELECT * FROM reservation";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/reservation?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "salta0707";
    Connection conn = null;
    Statement stmt = null;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<VisitorsTable> list = FXCollections.observableArrayList();
        try {

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_QUERY);
            while(rs.next()) {
                list.add(new VisitorsTable(
                        rs.getInt("id_reservation"),
                        rs.getString("name") + " " + rs.getString("surname"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("room_type"),
                        rs.getString("created_at")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        id.setCellValueFactory(new PropertyValueFactory("id"));
        fullname.setCellValueFactory(new PropertyValueFactory("fullname"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        phone.setCellValueFactory(new PropertyValueFactory("phone"));
        room.setCellValueFactory(new PropertyValueFactory("room"));
        createdat.setCellValueFactory(new PropertyValueFactory("createdat"));

        visitorstable.setItems((ObservableList<VisitorsTable>) list);
        FXMLLoader loader = new FXMLLoader();
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

    }}
