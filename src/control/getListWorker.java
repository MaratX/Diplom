package control;

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
 * Created by Gustovs on 14.06.2017.
 */
@WebServlet(name = "getListWorker", value = "/getListWorker")
public class getListWorker extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            pw.print(new MyCompanyDAO().getListWorker(req.getParameter("organization")));
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
}
