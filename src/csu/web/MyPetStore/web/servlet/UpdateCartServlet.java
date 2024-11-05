package csu.web.MyPetStore.web.servlet;

import csu.web.MyPetStore.domain.Cart;
import csu.web.MyPetStore.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {
    protected static final String Cart_Form="/WEB-INF/jsp/Cart/Cart.jsp";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Cart cart= (Cart) session.getAttribute("cart");
        if(cart==null){
            cart=new Cart();
        }
        Iterator<CartItem> cartItems=cart.getAllCartItems();

        while (cartItems.hasNext()) {
            CartItem cartItem = (CartItem) cartItems.next();
            String itemId = cartItem.getItem().getItemId();
            try {
                String quantityString=req.getParameter(itemId);
                int quantity = Integer.parseInt(quantityString);


                cart.setQuantityByItemId(itemId, quantity);
                if (quantity < 1) {
                    cartItems.remove();
                }
            } catch (Exception e) {
                //ignore parse exceptions on purpose
            }
    }
        req.getRequestDispatcher(Cart_Form).forward(req,resp);
    }
}
