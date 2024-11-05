package csu.web.MyPetStore.web.servlet;

import csu.web.MyPetStore.domain.Cart;
import csu.web.MyPetStore.domain.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/removeCartItem")
public class RemoveCartItemServlet extends HttpServlet {
    protected static final String ERROR_Form="/WEB-INF/jsp/common/error.jsp";
    protected static final String Cart_Form="/WEB-INF/jsp/Cart/Cart.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Cart cart= (Cart) session.getAttribute("cart");
        if(cart==null){
            cart=new Cart();
        }
String workingItemId=req.getParameter("workingItemId");
        Item item = cart.removeItemById(workingItemId);

        if (item == null) {
            session.setAttribute("errormsg","Attempted to remove null CartItem from Cart.");
            req.getRequestDispatcher(ERROR_Form).forward(req,resp);

        } else {
            req.getRequestDispatcher(Cart_Form).forward(req,resp);
        }
    }
}
