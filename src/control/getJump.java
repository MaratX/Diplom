package control;

import lib_dep.MyCompanyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Gustovs on 02.06.2017.
 */
@WebServlet(name = "company", value = "/company")
public class getJump extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nameUser = req.getParameter("nameUser");
        int idOrganization = Integer.parseInt(req.getParameter("idOrganization"));
        String role = "";
        MyCompanyDAO company = new MyCompanyDAO();
        try {
            role = company.getInCompanyRole(nameUser, idOrganization);
        }catch (SQLException e){
            System.out.println("Error: " + e);
        }
        if(role.equals("worker")) {
            req.getRequestDispatcher("WEB-INF/view/worker.jsp").forward(req, resp);
        }if(role.equals("boss")){
            req.getRequestDispatcher("WEB-INF/view/company.jsp").forward(req,resp);
        }
    }
}
