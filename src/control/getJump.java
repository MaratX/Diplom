package control;

import DAO.MyCompanyDAO;
import DAO.OrganizationDAO;
import objects.Organization;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Gustovs on 02.06.2017.
 */
@WebServlet(name = "company", value = "/company")
public class getJump extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nameUser = req.getParameter("nameUser");
        int idOrganization = Integer.parseInt(req.getParameter("idOrganization"));
        String role = "";
        String OrgName = "";
        MyCompanyDAO company = new MyCompanyDAO();
        try {
            role = company.getInCompanyRole(nameUser, idOrganization);
            Organization o = new OrganizationDAO().getOrganizationById(idOrganization);
            OrgName = o.getName_Organization();
        }catch (SQLException e){
            System.out.println("Error: " + e);
        }
        HttpSession session = req.getSession();
        if(role.equals("работник")) {
            session.setAttribute("organization", OrgName);
            req.getRequestDispatcher("WEB-INF/view/worker.jsp").forward(req, resp);
        }if(role.equals("руководитель")){
            session.setAttribute("organization", OrgName);
            req.getRequestDispatcher("WEB-INF/view/company.jsp").forward(req,resp);
        }
    }
}
