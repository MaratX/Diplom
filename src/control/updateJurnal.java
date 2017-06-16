package control;

import lib_dep.AddressDAO;
import lib_dep.JurnalOffDAO;
import objects.JurnalOff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Gustovs on 16.06.2017.
 */
@WebServlet(name = "updatejurnal", value = "/updatejurnal")
public class updateJurnal extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idjurnal"));
        Date start = Date.valueOf(req.getParameter("start"));
        Date close = Date.valueOf(req.getParameter("close"));
        String desc = req.getParameter("desc");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        String home = req.getParameter("home");

        try {
            int resultJurnal = new JurnalOffDAO().updateJurnal(id, start, close, desc);
            int a = new JurnalOffDAO().getAddress(id);
            int  address = new AddressDAO().UpdateAddress(a, city, street, home, "0");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            String result = "";
            if(resultJurnal > 0){
                if(a > 0){
                    if(address > 0){
                        result = "ok";
                    }
                }
            }else{
                result = "bad";
            }
            pw.print(result);
        }catch (SQLException e){
            System.out.print("Error " + e);
        }
    }
}
