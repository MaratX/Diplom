package lib_dep;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by HMF on 21.02.2017.
 */
public class Account {
    private JDBC jdbc = new JDBC();
    private ResultSet rs;
    private String SqlAuthentication = "DECLARE @return BIT = 0;" +
            "IF EXISTS (SELECT userId, userPass FROM USER " +
            "WHERE userId = ? and userPass = ?) SET @return = 1;";


    public boolean Authentication (String login, String password){

        try{
            rs = jdbc.getStmt().executeQuery(SqlAuthentication);
            while (rs.next()){

            }
        }catch (SQLException e){

        }
        return false;
    }
    public String Authorization(){

        return "Error";
    }
}
