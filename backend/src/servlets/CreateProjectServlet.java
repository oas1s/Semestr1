package servlets;

import db.ConnectionToDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (req.getSession().getAttribute("email") == null) {
//            resp.sendRedirect("/signUp");
//        }
        req.getRequestDispatcher("WEB-INF/frontend/createProject.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String teacher_email = req.getParameter("teacher_email");
        String aclass =  req.getParameter("class");
        String description = req.getParameter("description");
        String date = req.getParameter("date");
        String status = req.getParameter("status");
        String type = req.getParameter("type");
        String links = req.getParameter("links");

        ConnectionToDB connectionToDB = new ConnectionToDB();
        String sql = "INSERT INTO projects(`teacher_email`,`class`,`description`,`date`,`status`,`type`,`links`) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection connection = connectionToDB.getInstance();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1 , teacher_email);
            stmt.setString(2 , aclass);
            stmt.setString(3 , description);
            stmt.setString(4 , date);
            stmt.setString(5 , status);
            stmt.setString(6 , type);
            stmt.setString(7 , links);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
