package db;

import models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String lastname;
    private String university;
    private String role;
    private String group;
    @Override
    public User mapRow(ResultSet row) throws SQLException {
        return new User(row.getString("email"),row.getString("password"),row.getString(""),row.getString(""),row.getString(""),row.getString(""),row.getString(""),row.getString(""));
    }
}
