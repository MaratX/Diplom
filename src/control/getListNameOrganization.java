package control;

import DAO.OrganizationDAO;

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
@WebServlet(name = "getNameOrganization", value = "/getNameOrganization")
public class getListNameOrganization extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            String login = req.getParameter("login");
            pw.print(new OrganizationDAO().getListName(login));
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
}
