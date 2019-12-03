package servlets;

import db.UserRepositoryImpl;
import models.User;
import db.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@MultipartConfig
public class ProfileSettingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/frontend/profileSettings.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = (String) req.getSession().getAttribute("email");
        String password = MD5Util.md5Custom(req.getParameter("password"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String lastname = req.getParameter("lastname");
        String unviversity = req.getParameter("university");
        String role = (String) req.getSession().getAttribute("role");
        String group = req.getParameter("group");

        req.getSession().setAttribute("email",email);
        req.getSession().setAttribute("password",password);
        req.getSession().setAttribute("name",name);
        req.getSession().setAttribute("surname",surname);
        req.getSession().setAttribute("lastname",lastname);
        req.getSession().setAttribute("university",unviversity);
        req.getSession().setAttribute("role",role);
        req.getSession().setAttribute("group",group);

        InputStream inputStream = null;

        Part filePart = req.getPart("photo");

        if(filePart != null) {
            inputStream = filePart.getInputStream();
        }

        File avatar = new File(req.getServletContext().getRealPath("") + "/static/avatars/"
                + ((int) (Math.random() * 1000))  + ".jpg");


        System.out.println(avatar.getAbsolutePath());
        avatar.createNewFile();

        req.getSession().setAttribute("photo","/static/avatars/" + avatar.getName());
        System.out.println(avatar.getName());

        FileOutputStream fileOutputStream = new FileOutputStream(avatar);
        byte data[] = new byte[1024];
        int byteCount;

        while ((byteCount = inputStream.read(data, 0, 1024)) != -1) {
            fileOutputStream.write(data, 0, byteCount);
        }

        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();

        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User user = new User((String) req.getSession().getAttribute("email"),req.getParameter("password"),req.getParameter("name"),req.getParameter("surname"),
                req.getParameter("lastname"),req.getParameter("university"),(String) req.getSession().getAttribute("role"),req.getParameter("group"),avatar.getName());
        userRepository.update(user);
        resp.sendRedirect("/profile");
    }
}
