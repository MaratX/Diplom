package control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Gustovs on 13.02.2017.
 */
@WebServlet(name = "userOpen", value = "/userOpen")
public class UserOpen extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("login");
        String p = req.getParameter("pass");
        if(s.equals("marat")&& p.equals("root")){
            req.getRequestDispatcher("WEB-INF/view/user.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("WEB-INF/view/company.jsp").forward(req, resp);
        }
    }
}
