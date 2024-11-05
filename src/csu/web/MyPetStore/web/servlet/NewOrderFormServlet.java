package csu.web.MyPetStore.web.servlet;

import csu.web.MyPetStore.domain.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/newOrderForm")
public class NewOrderFormServlet extends HttpServlet {
    protected static final String NEW_ORDER_Form="/WEB-INF/jsp/order/newOrder.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();

        List<String> cardList = new ArrayList<String>();
        cardList.add("Visa");
        cardList.add("MasterCard");
        cardList.add("American Express");
        session.setAttribute("cardList",cardList);
        Account loginAccount=(Account) session.getAttribute("loginAccount");
        if(loginAccount==null){
            resp.sendRedirect("signonForm");
        }else{
            req.getRequestDispatcher(NEW_ORDER_Form).forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
