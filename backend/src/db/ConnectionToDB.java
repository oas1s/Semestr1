package db;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Map;
import java.util.Properties;

public class ConnectionToDB {
    java.sql.Connection connection;

    public java.sql.Connection getInstance() throws SQLException, ClassNotFoundException {
        if (connection == null) {
//            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/project1";
            String user = "root";
            String password = "azat1504";
            Properties props = new Properties();
            props.setProperty("user",user);
            props.setProperty("password",password);
            try {
                this.connection = DriverManager.getConnection(url, props);
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
        return connection;
    }
}
