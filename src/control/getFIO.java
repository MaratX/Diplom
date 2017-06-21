package control;

import DAO.AccountDAO;
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
@WebServlet(name = "getfio", value = "/getfio")
public class getFIO extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            int idUser = new AccountDAO().getIdUser(req.getParameter("login"));
            User u = new AccountDAO().getUser(idUser);
            String name = "имя";
            String lastName = "фамилия";
            String phone = "номер телефона";
            if(u.getName() != null){
                name = u.getName();
            }
            if(u.getLastName() != null){
                lastName = u.getLastName();
            }
            if(u.getPhone() != null){
                phone = u.getPhone();
            }
            PrintWriter pw = resp.getWriter();
            pw.print(name + "_" + lastName + "_" + phone);
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }
}
