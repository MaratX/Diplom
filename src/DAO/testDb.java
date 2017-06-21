package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by HMF on 27.02.2017.
 */
public class testDb {
    private static final String URL = "jdbc:mysql://localhost:3306/diplom?useSSL=false";
    private static final String User = "root";
    private static final String Password = "root";
    private static Connection con;
    private static Statement stmt;


    public static void main(String... args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            if(con == null){
                con = DriverManager.getConnection(URL, User, Password);
                stmt = con.createStatement();
                String sql = "insert into user value('marat', 'root')";
                stmt.executeUpdate(sql);


            }
            }catch (SQLException |ClassNotFoundException e){
                System.out.println("Error: " + e);
            }
    }

}
