package servlets;

import db.ConnectionToDB;
import db.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/frontend/signUp.html").forward(req,resp);
//        System.out.println("asdasdasdsdsa");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("Name");
        String Surname = req.getParameter("Surname");
        String Lastname = req.getParameter("Lastname");
        String University = req.getParameter("University");
        String Role = req.getParameter("Role");
        String Group = req.getParameter("Group");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        password = MD5Util.md5Custom(password);
        System.out.println(password);
        ConnectionToDB connectionToDB = new ConnectionToDB();
        String sql = "INSERT INTO reg_clients (`email`,`password`,`name`,`surname`,`lastname`,`university`,`role`,`group`) VALUES( ?, ?, ?, ?, ?,?,?,?)";
        try {
            Connection connection = connectionToDB.getInstance();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1 , email);
            stmt.setString(2 , password);
            stmt.setString(3 , name);
            stmt.setString(4 , Surname);
            stmt.setString(5 , Lastname);
            stmt.setString(6 , University);
            stmt.setString(7 , Role);
            stmt.setString(8 , Group);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
