import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyServlet extends HttpServlet {
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
        root.put("head", "Hi, some random ");
        List items = new ArrayList<Integer>();
        for (int i=0; i<5; i++) {
            items.add(Math.random());
        }
        root.put("items", items);

        // соединяем модель и шаблон
        Template t = cfg.getTemplate("tape.ftlh");
        try {
            t.process(root, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}