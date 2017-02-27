package lib_dep;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by HMF on 21.02.2017.
 */
public class Account {
    private JDBC jdbc = new JDBC();
    private ResultSet rs;
    private PreparedStatement ps;
    private String SqlAuthentication =  "DECLARE @return BIT = 0;" +
                                        "IF EXISTS (SELECT userId, userPass FROM USER " +
                                        "WHERE userId = ? and userPass = ?) SET @return = 1;";

    private String SqlAuthorization =   "" +
                                        "" +
                                        "";

    public boolean Authentication (String login, String password){

        try{
            ps = jdbc.getCon().prepareStatement(SqlAuthentication);
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
        }catch (SQLException e){
            System.out.println("Error: " + e);
            return false;
        }
        return false;
    }
    public String Authorization(String login, String password){
        try{
            ps = jdbc.getCon().prepareStatement(SqlAuthorization);
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
        }catch (SQLException e){
            System.out.println("Error: " + e);
        }
        return "Error";
    }
}
