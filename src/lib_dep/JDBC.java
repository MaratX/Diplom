package lib_dep;

import java.io.IOException;
import java.sql.*;

/**
 * Created by HMF on 21.02.2017.
 */
public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/diplom?useSSL=false";
    private static final String User = "root";
    private static final String Password = "root";

    private static Connection con;
    private static Statement stmt;

    public Connection getCon(){

        if(con == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(URL, User, Password);
            }catch (SQLException | ClassNotFoundException e){
                error(e);
                return null;
            }
        }
        return con;
    }

    public Statement getStmt(){
        if(stmt == null){
            try {
                stmt = getCon().createStatement();
            }catch (SQLException e){
                error(e);
                return null;
            }
        }
        return stmt;
    }

    public void Close(){
        try {
            if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
        }catch (SQLException e){
            error(e);
        }
    }

    private void error(Exception e){
        System.out.println("Error: " + e);
    }
}
