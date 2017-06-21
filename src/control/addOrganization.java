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
 * Created by Gustovs on 31.03.2017.
 */
@WebServlet(name="addOrganization", value = "/addOrganization")
public class addOrganization extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            PrintWriter pw = resp.getWriter();
            OrganizationDAO organizationDAO = new OrganizationDAO();
            pw.print(organizationDAO.createOrganization(req.getParameter("nameOrganization"), 0));
        }catch (SQLException e){
            System.out.println("Error: " + e);
        }
    }
}
