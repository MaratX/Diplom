package control;

import DAO.JurnalOffDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Gustovs on 11.06.2017.
 */
@WebServlet(name = "getUserListJurnalOff", value = "/getUserListJurnalOff")
public class getUserListJurnalOff extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            JurnalOffDAO Jo = new JurnalOffDAO();
            String list = Jo.getListUserJurnalOff(req.getParameter("login"));
            PrintWriter pw = resp.getWriter();
            pw.print(list);
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
}
