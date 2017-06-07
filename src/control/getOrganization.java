package control;

import lib_dep.AddressDAO;
import lib_dep.OrganizationDAO;
import objects.Address;
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
 * Created by Gustovs on 30.05.2017.
 */
@WebServlet(name = "getOrganization", value = "/getOrganization")
public class getOrganization extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            OrganizationDAO organizationDAO = new OrganizationDAO();
            Organization organization = new Organization();
            AddressDAO addressDAO = new AddressDAO();
            Address address = new Address();
            int org = Integer.parseInt(req.getParameter("idOrganization"));
            System.out.println(org);
            organization = organizationDAO.getOrganizationById(org);
            address = addressDAO.getAddressById(organization.getLegalAddressOrganization());

            String result = toString(organization.getId_Organization(), organization.getName_Organization(), address.getCity() + " "+ address.getHome() + " " + address.getApartment());
            pw.print(result);
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
    public String toString (int id, String name, String address){
        return id +"|"+ name +"|"+ address;
    }
}
