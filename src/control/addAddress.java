package control;

import DAO.AccountDAO;
import DAO.AddressDAO;
import objects.User;

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
@WebServlet(name = "addaddress", value = "/addaddress")
public class addAddress extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        try {
            int idUser = new AccountDAO().getIdUser(req.getParameter("login"));
            User u = new AccountDAO().getUser(idUser);
            pw.print(new AddressDAO().UpdateAddress(u.getAddressUser(), req.getParameter("city"), req.getParameter("street"), req.getParameter("home"), req.getParameter("apart")));
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
}
