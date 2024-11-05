package csu.web.MyPetStore.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/orderAction")
public class OrderActionServlet extends HttpServlet {
  private static final String Order_FORM = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    List<String> cardList = new ArrayList<String>();
    cardList.add("Visa");
    cardList.add("MasterCard");
    cardList.add("American Express");
    session.setAttribute("cardList",cardList);
    req.getRequestDispatcher(Order_FORM).forward(req,resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}

