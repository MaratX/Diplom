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

/**
 * Created by Gustovs on 31.03.2017.
 */
@WebServlet(name = "getCompany", value = "/getCompany")
public class getCompany extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            MyCompanyDAO myCompanyDAO = new MyCompanyDAO();
            int i = Integer.parseInt(req.getParameter("idCompany"));
            MyCompany myCompany = myCompanyDAO.getMyCompany(i);
            PrintWriter pw = resp.getWriter();
            pw.print(toString(myCompany));
;        }catch (SQLException e){
            System.out.println("Error : " + e);
        }
    }
    public String toString(MyCompany myCompany){
        return "{ \"id\" :\"" + myCompany.getIdMyCompany() + "\" , \"idUser\" : \"" + myCompany.getIdUser() + "\", \"idOrganization\" : \"" + myCompany.getIdOrganization() + "\"}";
    }
}
