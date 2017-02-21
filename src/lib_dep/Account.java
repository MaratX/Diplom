package lib_dep;

import java.io.IOException;
import java.sql.ResultSet;

/**
 * Created by HMF on 21.02.2017.
 */
public class Account {
    private JDBC jdbc = new JDBC();
    private ResultSet rs;
    private String SqlAuthentication = "select idUser, pass from user";


    public boolean Authentication (String login, String password){

        try{

        }catch (IOException e){

        }
        return false;
    }
    public String Authorization(){

        return "Error";
    }
}
