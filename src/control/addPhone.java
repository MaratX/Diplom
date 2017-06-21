package control;

import DAO.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Gustovs on 15.06.2017.
 */
@WebServlet(name = "addPhone", value = "/addPhone")
public class addPhone extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            String phone = req.getParameter("phone");
            int idUser = new AccountDAO().getIdUser(req.getParameter("login"));
            int result = new AccountDAO().addPhone(phone, idUser);
            PrintWriter pw = resp.getWriter();
            pw.print(result);
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
}
