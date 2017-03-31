package control;

import lib_dep.OrganizationDAO;
import objects.Organization;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Gustovs on 29.03.2017.
 */
@WebServlet(name="company", value = "/company")
public class company extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            OrganizationDAO organization = new OrganizationDAO();
            PrintWriter ps = resp.getWriter();
            ps.print(organization.isOrganization(req.getParameter("loginA")));

        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
}
