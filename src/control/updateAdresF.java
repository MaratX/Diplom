package control;

import lib_dep.AddressDAO;
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
 * Created by Gustovs on 16.06.2017.
 */
@WebServlet(name = "updateAdresF", value = "/updateAdresF")
public class updateAdresF extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            String [] idO = req.getParameter("idOrg").split("#");
            Organization o = new OrganizationDAO().getOrganizationById(Integer.parseInt(idO[0]));
            int i = new AddressDAO().UpdateAddress(o.getLegalAddressOrganization(), req.getParameter("city"), req.getParameter("street"),
                    req.getParameter("home"), req.getParameter("apart"));
            pw.print(i);
        }catch (SQLException e){
            System.out.print("Error " + e);
        }
    }
}
