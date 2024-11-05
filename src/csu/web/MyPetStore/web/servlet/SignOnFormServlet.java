package csu.web.MyPetStore.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/signonForm")
public class SignOnFormServlet extends HttpServlet {
    protected static final String SIGN_ON_Form="/WEB-INF/jsp/account/signon.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(SIGN_ON_Form).forward(req,resp);
    }
}
