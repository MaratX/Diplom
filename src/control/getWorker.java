package control;

import DAO.AccountDAO;
import DAO.MyCompanyDAO;
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
 * Created by Gustovs on 16.06.2017.
 */
@WebServlet(name = "getworker", value = "/getworker")
public class getWorker extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            int idUser = Integer.parseInt(req.getParameter("idworker"));
            String[] idOrg = req.getParameter("organization").split("#");
            String role = new MyCompanyDAO().getRole(idUser, Integer.parseInt(idOrg[0]));
            User u = new AccountDAO().getUser(idUser);
            String result = idUser + "_" + u.getLogin() + "_" + u.getName() + " " + u.getLastName() + "_" + role;
            pw.print(result);
        }catch (SQLException e){
            System.out.print("Error " + e);
        }
    }
}
