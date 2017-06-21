package control;

import DAO.AddressDAO;
import DAO.JurnalOffDAO;
import objects.JurnalOff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Gustovs on 06.06.2017.
 */
@WebServlet(name = "addJurnalOff", value = "/addJurnalOff")
public class addJurnalOff extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            AddressDAO addressDAO = new AddressDAO();
            int address = addressDAO.searchAdress(req.getParameter("address"));
            String offStart = req.getParameter("offStart");
            String offClose = req.getParameter("offClose");
            String description = req.getParameter("protection");
            int    idOrganization = Integer.parseInt(req.getParameter("idOrganization"));


            JurnalOff jurnalOff = new JurnalOff();
            jurnalOff.setAddress(address);
            jurnalOff.setDescription(description);
            jurnalOff.setOffStart(offStart);
            jurnalOff.setOffClose(offClose);
            jurnalOff.setIdOrganization(idOrganization);


            JurnalOffDAO jurnalOffDAO = new JurnalOffDAO();
            int result = jurnalOffDAO.AddJurnalOff(jurnalOff);
            PrintWriter ps = resp.getWriter();
            ps.print(result);
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
}
