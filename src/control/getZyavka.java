package control;

import lib_dep.AccountDAO;
import lib_dep.ProposalDAO;
import objects.Proposal;

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
@WebServlet(name = "getzyavka", value = "/getzyavka")
public class getZyavka extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        int idz = Integer.parseInt(req.getParameter("idz"));
        String result = "";
        try {
            Proposal s = new ProposalDAO().getZyavka(idz);

            result += s.getDescription() + "_" + new AccountDAO().getLoginUser(s.getIdUser()) + "_" + s.getStatus() + "_" + s.getAnswer() + "_" + idz;
            pw.print(result);
        }catch (SQLException e){
            System.out.print(e);
        }
    }
}
