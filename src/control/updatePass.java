package control;

import DAO.AccountDAO;

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
@WebServlet(name = "updatePass", value = "/updatePass")
public class updatePass extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            int id = new AccountDAO().getIdUser(req.getParameter("login"));
            pw.print(new AccountDAO().UpdatePass(id, req.getParameter("pass")));
        }catch (SQLException e){
            System.out.print("Error" + e);
        }
    }
}
