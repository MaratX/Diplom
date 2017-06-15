package control;

import lib_dep.AccountDAO;
import lib_dep.AddressDAO;
import objects.Address;
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
 * Created by Gustovs on 15.06.2017.
 */
@WebServlet(name = "getAddress", value = "/getAddress")
public class getAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            int idUser = new AccountDAO().getIdUser(req.getParameter("login"));
            User u = new AccountDAO().getUser(idUser);
            Address a = new AddressDAO().getAddressById(u.getAddressUser());
            String city = "город";
            String street = "улица";
            String home = "дом";
            String appartment = "квартира";

            if(a.getCity() != null){
                city = a.getCity();
            }
            if(a.getStreet() != null){
                street = a.getStreet();
            }
            if(a.getHome() != null){
                home = a.getHome();
            }
            if(a.getApartment() != null){
                appartment = a.getApartment();
            }
            String result = city + "_" + street + "_" + home + "_" + appartment + "_";
            PrintWriter pw = resp.getWriter();
            pw.print(result);
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
}
