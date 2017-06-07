package control;

import lib_dep.AccountDAO;
import lib_dep.ProposalDAO;
import objects.Proposal;

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
 * Created by Gustovs on 06.06.2017.
 */
@WebServlet(name = "getListZyavki", value = "/getListZyavki")
public class getListZyavki extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            int idOrganization = Integer.parseInt(req.getParameter("idOrganization"));
            ProposalDAO proposalDAO = new ProposalDAO();
            ArrayList<Proposal> list = proposalDAO.getListByID(idOrganization);
            String listJson = "";
            AccountDAO accountDAO = new AccountDAO();
            for(Proposal p : list){
                listJson += toString(p.getId(), p.getDescription(), accountDAO.getLoginUser(p.getIdUser()) , p.getStatus());
            }

            pw.print(listJson);
        }catch (SQLException e){
            System.out.println("Error : " + e);
        }
    }
    public String toString(int id, String description, String klient, String status){
        return id + "_" + description + "_" + klient + "_" + status + "|";
    }
}
