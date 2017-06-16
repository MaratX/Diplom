package control;

import lib_dep.AccountDAO;

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
@WebServlet(name = "getklient", value = "/getklient")
public class getKlient extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        try {
            String s = new AccountDAO().getLoginUser(Integer.parseInt(req.getParameter("idk")));
            pw.print(s + "_" + req.getParameter("idk"));
        }catch (SQLException e){
            System.out.print("Error" + e);
        }
    }
}
