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
 * Created by Gustovs on 16.06.2017.
 */
@WebServlet(name = "updateworker", value = "/updateworker")
public class updateworker extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            String [] s = req.getParameter("idOrg").split("#");
            pw.print(new MyCompanyDAO().updateRole(Integer.parseInt(req.getParameter("idUser")), Integer.parseInt(s[0]), req.getParameter("role")));
        }catch (SQLException e){
            System.out.print("Error " + e);
        }
    }
}
