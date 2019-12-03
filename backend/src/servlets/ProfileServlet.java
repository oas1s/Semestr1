package servlets;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        root.put("email", req.getSession().getAttribute("email"));
        root.put("password", req.getSession().getAttribute("password"));
        root.put("name", req.getSession().getAttribute("name"));
        root.put("surname", req.getSession().getAttribute("surname"));
        root.put("lastname", req.getSession().getAttribute("lastname"));
        root.put("university", req.getSession().getAttribute("university"));
        root.put("role", req.getSession().getAttribute("role"));
        root.put("group", req.getSession().getAttribute("group"));
        root.put("photo", req.getSession().getAttribute("photo"));

            // соединяем модель и шаблон
            Template t = cfg.getTemplate("profile.ftlh");
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
