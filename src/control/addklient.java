package control;

import lib_dep.AccountDAO;
import lib_dep.KlientDAO;

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
@WebServlet(name = "addklient", value = "/addklient")
public class addklient extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            String [] org = req.getParameter("organization").split("#");
            pw.print(new KlientDAO().addKlient(new AccountDAO().getIdUser(req.getParameter("login")), Integer.parseInt(org[0])));
        }catch (SQLException e){
            System.out.print("Error "+ e);
        }
    }
}
