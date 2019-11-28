package db;

import models.User;

import java.sql.*;
import java.util.Optional;

public class UserRepositoryImpl implements CRUDRepository<User> {

    @Override
    public void save(User user) {
        ConnectionToDB connectionToDB = new ConnectionToDB();
        String sql = "INSERT INTO reg_clients (`email`,`password`,`name`,`surname`,`lastname`,`university`,`role`,`group`) VALUES( ?, ?, ?, ?, ?,?,?,?)";
        try {
            Connection connection = connectionToDB.getInstance();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1 , user.getEmail());
            stmt.setString(2 , user.getPassword());
            stmt.setString(3 , user.getName());
            stmt.setString(4 , user.getSurname());
            stmt.setString(5 , user.getLastname());
            stmt.setString(6 , user.getUniversity());
            stmt.setString(7 , user.getRole());
            stmt.setString(8 , user.getGroup());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        ConnectionToDB connectionToDB = new ConnectionToDB();
        String sql = "UPDATE reg_clients SET `email`=?,`password`=?,`name`=?,`surname`=?,`lastname`=?,`university`=?,`role`=?,`group`=?,`avatar_path`=? WHERE `email`=?";
        try {
            Connection connection = connectionToDB.getInstance();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1 , user.getEmail());
            stmt.setString(2 , user.getPassword());
            stmt.setString(3 , user.getName());
            stmt.setString(4 , user.getSurname());
            stmt.setString(5 , user.getLastname());
            stmt.setString(6 , user.getUniversity());
            stmt.setString(7 , user.getRole());
            stmt.setString(8 , user.getGroup());
            stmt.setString(9,  user.getAvatarPath());
            stmt.setString(10, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User find(String email) {
        ConnectionToDB connectionToDB = new ConnectionToDB();
        String sql = "SELECT * FROM reg_clients WHERE (email = ?)";
        try {
            Connection connection = connectionToDB.getInstance();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,email);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                UserRowMapper userRowMapper = new UserRowMapper();
                User u = userRowMapper.mapRow(resultSet);
                return u;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(User user) {
        ConnectionToDB connectionToDB = new ConnectionToDB();
        String sql = "DELETE from reg_clients WHERE (email = ?)";
        try {
            Connection connection = connectionToDB.getInstance();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
