package control;

import lib_dep.AddressDAO;
import lib_dep.JurnalOffDAO;
import objects.Address;
import objects.JurnalOff;

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
@WebServlet(name = "getListJurnal", value = "/getListJurnal")
public class getListJurnalOff extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            int idOrganization = Integer.parseInt(req.getParameter("idOrganization"));
            JurnalOffDAO jurnalOffDAO = new JurnalOffDAO();
            ArrayList<JurnalOff> list = jurnalOffDAO.getListJurnalOff(idOrganization);
            AddressDAO addressDAO = new AddressDAO();

            String listJson = "";
            for(JurnalOff jurnalOff : list){
                Address address = addressDAO.getAddressById(jurnalOff.getAddress());
                listJson += toString(jurnalOff.getIdJurnalOff(), jurnalOff.getDescription(), address.getCity() + " " + address.getStreet() + " " + address.getHome(), jurnalOff.getOffStart(), jurnalOff.getOffClose());
            }
            pw.print(listJson);
        }catch (SQLException e){
            System.out.println("Error : " + e);
        }
    }
    public String toString(int id, String description, String address, String start, String close){
        return  id + "_" + description + "_" + address + "_" + start + "_" + close + "|";
    }
}
