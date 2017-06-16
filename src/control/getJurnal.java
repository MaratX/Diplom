package control;

import lib_dep.JurnalOffDAO;

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
@WebServlet(name = "getjurnal", value = "/getjurnal")
public class getJurnal extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idJurnal = Integer.parseInt(req.getParameter("idjurnal"));
        try{
        String result = new JurnalOffDAO().getJurnal(idJurnal);
        resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            pw.print(result);
        }catch (SQLException e){
            System.out.print("Error " + e);
        }
    }
}
