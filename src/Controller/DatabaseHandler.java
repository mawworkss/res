package Controller;

import java.sql.*;

public class DatabaseHandler extends Config {
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/reservation?serverTimezone=UTC";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "salta0707";
    private static final String INSERT_QUERY = "INSERT INTO " + Const.VISITOR_TABLE + "(" + Const.NAME + "," +
            Const.SURNAME + "," + Const.EMAIL + "," + Const.PHONE + "," + Const.CHECK_IN + "," +
            Const.CHECK_OUT + "," + Const.ROOMTYPE + ")" + " VALUES(?,?,?,?,?,?,?)";
    private static final String INSERT_QUERY_ROOM = "INSERT INTO " + Const.ROOM_TABLE + "(" +Const.ROOM_NUMBER +"," +
            Const.ROOMTYPE + "," + Const.PRICE + "," + Const.DESCRIPTION + "," + Const.HAS_CLEANING_SERVICE + "," +
            Const.HAS_FREE_WIFI + "," + Const.PETS_ALLOWED + ")" + " VALUES(?,?,?,?,?,?,?)";

    public static void insertRecord(String name, String surname, String email,
                                    String phone, String check_in, String check_out, String room_type) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement prst = connection.prepareStatement(INSERT_QUERY);
            prst.setString(1, name);
            prst.setString(2, surname);
            prst.setString(3, email);
            prst.setString(4, phone);
            prst.setString(5, String.valueOf(check_in));
            prst.setString(6, String.valueOf(check_out));
            prst.setString(7, room_type);
            prst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void insertRoom(String room_number, String room_type, String price,
                                  String description, String has_cleaning_service,
                                  String has_free_wifi, String pets_allowed) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL,
                    DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement prst = connection.prepareStatement(INSERT_QUERY_ROOM);
            prst.setString(1, room_number);
            prst.setString(2, room_type);
            prst.setInt(3, Integer.parseInt(price));
            prst.setString(4, description);
            prst.setInt(5, Integer.parseInt(has_cleaning_service));
            prst.setInt(6, Integer.parseInt(has_free_wifi));
            prst.setInt(7, Integer.parseInt(pets_allowed));
            prst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
