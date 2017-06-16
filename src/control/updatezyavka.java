package control;

import lib_dep.AccountDAO;
import lib_dep.ProposalDAO;

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
@WebServlet(name = "updatezyavka", value = "/updatezyavka")
public class updatezyavka extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idz = Integer.parseInt(req.getParameter("idz"));
        String status = req.getParameter("status");
        String answer = req.getParameter("answer");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        try {
            int worker = new AccountDAO().getIdUser(req.getParameter("worker"));
            pw.print(new ProposalDAO().update(idz, status, answer, worker));
        }catch (SQLException e){
            System.out.print("Error " + e);
        }
    }
}
