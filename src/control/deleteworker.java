package control;

import lib_dep.MyCompanyDAO;

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
@WebServlet(name = "deleteworker", value = "/deleteworker")
public class deleteworker extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            String [] idO = req.getParameter("idO").split("#");
            pw.print(new MyCompanyDAO().deleteWorker(Integer.parseInt(req.getParameter("idU")), Integer.parseInt(idO[0])));
        }catch (SQLException e){
            System.out.print("Error" + e);
        }
    }
}
