package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Gustovs on 13.02.2017.
 */
@WebServlet(name = "userOpen", value = "/userOpen")
public class UserOpen extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write(
                "<input type=\"text\" name=\"userName\"/>\n" +
                "<input type=\"password\" name=\"userPass\"/>\n" +
                "<input type=\"submit\" name=\"Вход\"/>"
        );
        out.close();
    }
}
