package control;

import DAO.AccountDAO;
import DAO.AddressDAO;
import DAO.MyCompanyDAO;
import DAO.OrganizationDAO;
import objects.Address;
import objects.MyCompany;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Gustovs on 31.03.2017.
 */
@WebServlet(name = "getListMyCompany", value = "/getListMyCompany")
public class getListMyCompany extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            MyCompanyDAO myCompanyDAO = new MyCompanyDAO();
            AccountDAO accountDAO = new AccountDAO();
            OrganizationDAO organizationDAO = new OrganizationDAO();
            AddressDAO addressDAO = new AddressDAO();
            int ii = accountDAO.getIdUser(req.getParameter("login"));
            ArrayList<MyCompany> list = myCompanyDAO.getListMyCompany(ii);
            String listJson = "";
            for(MyCompany m : list){
                String nameOrganization = organizationDAO.getOrganizationById(m.getIdOrganization()).getName_Organization();
                int idOrganization = m.getIdOrganization();
                Address adres = addressDAO.getAddressById(organizationDAO.getOrganizationById(m.getIdOrganization()).getLegalAddressOrganization());
                String adressOrganization = adres.getCity() + " " + adres.getHome() + " " + adres.getApartment();
                listJson += toString(idOrganization, nameOrganization, adressOrganization);

            }
            pw.print(listJson);
        }catch (SQLException e){
            System.out.println("Error : " + e);
        }
    }

    public String toString(int id, String name, String adress){
        return id + "|" + name + "|" + adress + "_";
    }

}
