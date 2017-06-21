package control;

import DAO.AccountDAO;
import DAO.MyCompanyDAO;

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
@WebServlet(name = "addworker", value = "/addworker")
public class addworker extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            int idU = new AccountDAO().getIdUser(req.getParameter("login"));
            String [] ss = req.getParameter("loginO").split("#");
            int idO = Integer.parseInt(ss[0]);
            String s = req.getParameter("role");
            pw.print(new MyCompanyDAO().addworker(idU, s, idO));
        }catch (SQLException e){
            System.out.print("Error" + e);
        }
    }
}
