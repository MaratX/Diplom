package control;

import DAO.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Gustovs on 19.03.2017.
 */
@WebServlet(name = "userRegistration", value = "/userRegistration")
public class userRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("loginReg");
        String p = req.getParameter("passReg");
        AccountDAO account = new AccountDAO();
        String result = account.Authorization(s, p);
        if(result.equals("registration completed successfully")){
            req.setAttribute("result", "Регистрация прошла успешно");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else {
            req.setAttribute("result", "Этот логин уже используеться");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
