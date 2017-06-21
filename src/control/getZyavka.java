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

/**
 * Created by Gustovs on 16.06.2017.
 */
@WebServlet(name = "getzyavka", value = "/getzyavka")
public class getZyavka extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        int idz = Integer.parseInt(req.getParameter("idz"));
        String result = "";
        try {
            Proposal s = new ProposalDAO().getZyavka(idz);
            Address a = new AddressDAO().getAddressById(new AccountDAO().getAdress(new AccountDAO().getLoginUser(s.getIdUser())));
            String adres = a.getCity() + " " + a.getStreet() + " " + a.getHome() + " " + a.getApartment();
            User u = new AccountDAO().getUser(s.getIdUser());
            result += s.getDescription() + "_" + new AccountDAO().getLoginUser(s.getIdUser()) + "_" + adres + "_" + u.getPhone() + "_" + s.getStatus() + "_" + s.getAnswer() + "_" + idz;
            pw.print(result);
        }catch (SQLException e){
            System.out.print(e);
        }
    }
}
