package csu.web.MyPetStore.web.servlet;

import csu.web.MyPetStore.domain.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private String signOnMsg;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repeatedPassword = req.getParameter("repeatedPassword");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address1 = req.getParameter("address1");
        String address2 = req.getParameter("address2");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String zip = req.getParameter("zip");
        String country = req.getParameter("country");
        String languagePreference = req.getParameter("languagePreference");
        String favouriteCategory = req.getParameter("favouriteCategory");
        boolean enableMylist = req.getParameter("enableMylist") != null;
        boolean enableBanner = req.getParameter("enableBanner") != null;
        String checkCode = req.getParameter("checkCode");
        String piccode = (String) req.getSession().getAttribute("piccode");
        resp.setContentType("text/html;charset=utf-8");//解决乱码问题
        PrintWriter out = resp.getWriter();

        if(checkCode.equals(piccode)){
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            account.setFirstName(firstname);
            account.setLastName(lastname);
            account.setEmail(email);
            account.setPhone(phone);
            account.setAddress1(address1);
            account.setAddress2(address2);
            account.setCity(city);
            account.setState(state);
            account.setZip(zip);
            account.setCountry(country);
            account.setLanguagePreference(languagePreference);
            account.setFavouriteCategoryId(favouriteCategory);
            account.setListOption(enableMylist);
            account.setBannerOption(enableBanner);

            req.getRequestDispatcher("/WEB-INF/jsp/catalog/main.jsp").forward(req,resp);
        }else{
            this.signOnMsg="驗證碼錯誤";
            req.setAttribute("signOnMsg", this.signOnMsg);
            req.getRequestDispatcher("/WEB-INF/jsp/account/newAccount.jsp").forward(req,resp);
        }
    }
}
