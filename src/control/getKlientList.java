package control;

import DAO.KlientDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Gustovs on 13.06.2017.
 */
@WebServlet(name = "getKlientList", value = "/getKlientList")
public class getKlientList extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            pw.print(new KlientDAO().getList(req.getParameter("organization")));
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
}
