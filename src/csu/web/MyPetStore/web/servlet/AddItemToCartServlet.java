package csu.web.MyPetStore.web.servlet;
import csu.web.MyPetStore.domain.Cart;
import csu.web.MyPetStore.domain.Item;
import csu.web.MyPetStore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addItemToCart")
public class AddItemToCartServlet extends HttpServlet{
    protected static final String Cart_Form="/WEB-INF/jsp/Cart/Cart.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String workingItemId=req.getParameter("workingItemId");
        HttpSession session=req.getSession();
        Cart cart= (Cart) session.getAttribute("cart");
        if(cart==null){
            cart=new Cart();
        }

        if (cart.containsItemId(workingItemId)) {
            cart.incrementQuantityByItemId(workingItemId);
        } else {
            CatalogService catalogService=new CatalogService();
            boolean isInStock = catalogService.isItemInStock(workingItemId);
            Item item = catalogService.getItem(workingItemId);
            cart.addItem(item, isInStock);
        }
        session.setAttribute("cart",cart);
        req.getRequestDispatcher(Cart_Form).forward(req,resp);
    }
}