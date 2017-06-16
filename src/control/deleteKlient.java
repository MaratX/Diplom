package control;

import lib_dep.AccountDAO;
import lib_dep.KlientDAO;
import lib_dep.OrganizationDAO;

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
@WebServlet(name = "deleteklient", value = "/deleteklient")
public class deleteKlient extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        try{
            int idKlient = new AccountDAO().getIdUser(req.getParameter("klient"));
            String [] listo = req.getParameter("nameo").split("#");
            pw.print(new KlientDAO().deleteKlient(idKlient, Integer.parseInt(listo[0])));
        }catch (SQLException e){
            System.out.print("Error " + e);
        }
    }
}
