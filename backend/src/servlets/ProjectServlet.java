package servlets;

import db.ConnectionToDB;
import db.MD5Util;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);

        // изменить в коде примера: нам нужно получать путь из ServletContext
        ServletContext servletContext = getServletContext();
        cfg.setServletContextForTemplateLoading(servletContext,"WEB-INF/frontend/");

        // дальше всё так же
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);


        // модель
        Map root = new HashMap();
        ConnectionToDB connectionToDB = new ConnectionToDB();
        String sql = "select * from projects where (id = ?)";
        try {
            Connection connection = connectionToDB.getInstance();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                root.put("teacher_email",resultSet.getString("teacher_email"));
                System.out.println(resultSet.getString("class"));
                System.out.println(resultSet.getString("description"));
                root.put("aclass",resultSet.getString("class"));
                root.put("description",resultSet.getString("description"));
                root.put("date",resultSet.getString("date"));
                root.put("status",resultSet.getString("status"));
                root.put("type",resultSet.getString("type"));
                root.put("links",resultSet.getString("links"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // соединяем модель и шаблон
        Template t = cfg.getTemplate("project.ftlh");
        try {
            t.process(root, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
