package control;

import DAO.AddressDAO;
import DAO.OrganizationDAO;
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
 * Created by Gustovs on 16.06.2017.
 */
@WebServlet(name = "getAdressUir", value = "/getAdressUir")
public class getAdressUir extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            resp.setCharacterEncoding("UTF-8");
            String [] s = req.getParameter("idOrg").split("#");
            Organization o = new OrganizationDAO().getOrganizationById(Integer.parseInt(s[0]));
            Address a = new AddressDAO().getAddressById(o.getPhysicalAddressOrganization());
            String result = a.getCity() + "_" + a.getStreet() + "_" + a.getHome() + "_" + a.getApartment();
            PrintWriter pw = resp.getWriter();
            pw.print(result);
        }catch (SQLException e){
            System.out.print("Error "+ e);
        }
    }
}
