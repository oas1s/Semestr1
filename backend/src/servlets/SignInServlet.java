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
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/frontend/signIn.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(email + " " + password);
        ConnectionToDB connectionToDB = new ConnectionToDB();
        String sql = "select * from reg_clients where (email = ?)";
        try {
            Connection connection = connectionToDB.getInstance();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,email);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()) {
               if (resultSet.getString("password").equals(MD5Util.md5Custom(password))) {
                  resp.getWriter().write("succes");
                  req.getSession().setAttribute("email",email);
                  req.getSession().setAttribute("password",password);
                  req.getSession().setAttribute("name",resultSet.getString("name"));
                   req.getSession().setAttribute("surname",resultSet.getString("surname"));
                   req.getSession().setAttribute("lastname",resultSet.getString("lastname"));
                   req.getSession().setAttribute("university",resultSet.getString("university"));
                   req.getSession().setAttribute("role",resultSet.getString("role"));
                   req.getSession().setAttribute("group",resultSet.getString("group"));
                   System.out.println(req.getSession().getAttribute("email"));
                   System.out.println(req.getSession().getAttribute("name"));
                   System.out.println(req.getSession().getAttribute("role"));

               }
               else {
                   resp.getWriter().write("wrond password");
               }
            }
            else {
                resp.getWriter().write("this mail dont exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
