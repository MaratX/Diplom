package control;

import DAO.AccountDAO;
import DAO.AddressDAO;
import DAO.ProposalDAO;
import objects.Address;
import objects.Proposal;
import objects.User;

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
            String [] idOrg = req.getParameter("idOrganization").split("#");
            int idOrganization = Integer.parseInt(idOrg[0]);
            ProposalDAO proposalDAO = new ProposalDAO();
            ArrayList<Proposal> list = proposalDAO.getListByID(idOrganization);
            String listJson = "";
            AccountDAO accountDAO = new AccountDAO();

            for(Proposal p : list){
                Address a = new AddressDAO().getAddressById(accountDAO.getAdress(accountDAO.getLoginUser(p.getIdUser())));
                String adress = a.getCity() + " " + a.getStreet() + " " + a.getHome() + " " + a.getApartment();
                User phone = accountDAO.getUser(p.getIdUser());
                listJson += toString(p.getId(), p.getDescription(), accountDAO.getLoginUser(p.getIdUser()) , p.getStatus(), adress,  p.getAnswer(), phone.getPhone());
            }

            pw.print(listJson);
        }catch (SQLException e){
            System.out.println("Error : " + e);
        }
    }
    public String toString(int id, String description, String klient, String status, String adress,  String answer, String phone){
        return id + "_" + description + "_" + klient + "_" + status + "_" + adress + "_" + answer + "_" + phone + "|";
    }
}
