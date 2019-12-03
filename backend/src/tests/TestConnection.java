package tests;

import db.ConnectionToDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
    public static void main(String[] args) {
        ConnectionToDB connectionToDB = new ConnectionToDB();
        try {
            Connection connection = connectionToDB.getInstance();
            String sql = "INSERT INTO reg_clients (`email`,`password`,`name`,`surname`,`lastname`,`university`,`role`,`group`) VALUES('asdasd','asdasd','asdasd','asdasd','asdasd','asdasd','asdasd','a')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
