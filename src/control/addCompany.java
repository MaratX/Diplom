package control;

import DAO.AccountDAO;
import DAO.MyCompanyDAO;
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
 * Created by Gustovs on 29.03.2017.
 */
@WebServlet(name="addCompany", value = "/addCompany")
public class addCompany extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            OrganizationDAO organization = new OrganizationDAO();
            MyCompanyDAO myCompanyDAO = new MyCompanyDAO();
            AccountDAO accountDAO = new AccountDAO();

            PrintWriter ps = resp.getWriter();
            int  idOrganization = organization.createOrganization(req.getParameter("nameOrganization"), 0);
            int idCompany = myCompanyDAO.createMyCompany(accountDAO.getIdUser(req.getParameter("nameUser")), idOrganization);
            ps.print(idCompany);
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
}
