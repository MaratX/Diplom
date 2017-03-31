package control;

import lib_dep.MyCompanyDAO;
import objects.MyCompany;

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
 * Created by Gustovs on 31.03.2017.
 */
@WebServlet(name = "getListMyCompany", value = "/getListMyCompany")
public class getListMyCompany extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            PrintWriter pw = resp.getWriter();
            MyCompanyDAO myCompanyDAO = new MyCompanyDAO();
            ArrayList<MyCompany> list = myCompanyDAO.getListMyCompany(Integer.parseInt(req.getParameter("idUser")));
            String listJson = "";
            for(MyCompany m : list){
                listJson += toString(m) + " ";
            }
            pw.print(listJson);
        }catch (SQLException e){
            System.out.println("Error : " + e);
        }
    }

    public String toString(MyCompany myCompany){
        return "{ \"id\" :\"" + myCompany.getIdMyCompany() + "\" , \"idUser\" : \"" + myCompany.getIdUser() + "\", \"idOrganization\" : \"" + myCompany.getIdOrganization() + "\"}";
    }
}
