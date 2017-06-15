package control;

import lib_dep.AccountDAO;
import lib_dep.OrganizationDAO;
import lib_dep.ProposalDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Date;

/**
 * Created by Gustovs on 14.06.2017.
 */
@WebServlet(name = "addProposal", value = "/addProposal")
public class addProposal extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter pw = resp.getWriter();
            int idUser = new AccountDAO().getIdUser(req.getParameter("user"));
            int idOrg = new OrganizationDAO().getIdOrganization(req.getParameter("option"));
            boolean id = new ProposalDAO().addProposal(idUser, req.getParameter("description"), "открыт", idOrg);
               if(id) {
                   pw.print("ok");
               }
        }catch (SQLException e){
            System.out.print("Error " + e);
        }
    }
}
