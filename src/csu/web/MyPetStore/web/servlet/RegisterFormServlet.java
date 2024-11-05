package csu.web.MyPetStore.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/registerForm")
public class RegisterFormServlet extends HttpServlet {
    private static final String REGISTER_FORM = "/WEB-INF/jsp/account/newAccount.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        List<String> languages = new ArrayList<String>();
        languages.add("english");
        languages.add("japanese");
        session.setAttribute("languages",languages);

        List<String> categories = new ArrayList<>();
        categories.add("FISH");
        categories.add("DOGS");
        categories.add("REPTILES");
        categories.add("CATS");
        categories.add("BIRDS");
        session.setAttribute("categories",categories);
        req.getRequestDispatcher(REGISTER_FORM).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
