package lib_dep;

import objects.Address;
import objects.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by HMF on 21.02.2017.
 */
public class AccountDAO {
    private JDBC jdbc = new JDBC();
    private ResultSet rs;
    private PreparedStatement ps;

    private String SqlAuthentication =  "SELECT count(iduser) = 1 FROM user WHERE login = ? AND password = ?;";
    private String sqlUpdateUser = "UPDATE user SET password = ? WHERE login = ?";
    private String SqlTestName = "SELECT count(iduser) > 0 FROM user WHERE login = ?";
    private String SqlAuthorization =   "INSERT INTO user (login, password, addressUser) VALUES (?, ?, ?)";
    private String sqlGetUserId = "SELECT idUser FROM user WHERE login = ?";
    private String sqlGetLogin = "SELECT login FROM user WHERE iduser = ?";
    private String sqlUser = "SELECT login, name, addressUser, lastname, phone FROM user WHERE iduser= ?";
    private String sqladdfio = "UPDATE user SET name= ?, lastName = ? WHERE idUser = ?";
    private String sqlAddPhone = "UPDATE user SET phone = ? WHERE idUser = ?";
    private String sqlUpdatePass = "UPDATE user SET password = ? WHERE idUser = ?";

    public int UpdatePass(int idUser, String pass) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlUpdatePass);
        ps.setString(1, pass);
        ps.setInt(2, idUser);
        return ps.executeUpdate();
    }

    public boolean Authentication (String login, String password){

        try{
            ps = jdbc.getCon().prepareStatement(SqlAuthentication);
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt(1) == 1){
                    return true;
                }
            }
        }catch (SQLException e){
            System.out.println("Error: " + e);
            return false;
        }
        return false;
    }

    public String Authorization(String login, String password){
        try{
            AddressDAO addressDAO = new AddressDAO();
            ps = jdbc.getCon().prepareStatement(SqlTestName);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt(1) == 1){
                    return "This login is registered";
                }else{
                    ps = jdbc.getCon().prepareStatement(SqlAuthorization);
                    ps.setString(1, login);
                    ps.setString(2, password);
                    ps.setInt(3, addressDAO.createAddress(new Address()));
                    ps.executeUpdate();
                    return "registration completed successfully";
                }
            }
        }catch (SQLException e){
            System.out.println("Error: " + e);
        }
        return "Error";
    }

    public int updateUser(String login, String password) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlUpdateUser);
        ps.setString(1, login);
        ps.setString(2, password);
        return ps.executeUpdate();
    }

    public int getIdUser(String login) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlGetUserId);
        ps.setString(1, login);
        rs = ps.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }

    public String getLoginUser(int id) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlGetLogin);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
            return rs.getString(1);
        }else {
            return null;
        }
    }

    public User getUser(int id) throws SQLException{
        User result = new User();
        ps = jdbc.getCon().prepareStatement(sqlUser);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
            result.setId(id);
            result.setLogin(rs.getString(1));
            result.setAddressUser(rs.getInt(3));
            result.setName(rs.getString(2));
            result.setLastName(rs.getString(4));
            result.setPhone(rs.getString(5));
        }
        return result;
    }

    public int addfio(String name, String lastName, int idUser) throws SQLException{
        ps =jdbc.getCon().prepareStatement(sqladdfio);
        ps.setString(1, name);
        ps.setString(2, lastName);
        ps.setInt(3, idUser);
        return ps.executeUpdate();
    }

    public int addPhone(String phone, int idUser) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlAddPhone);
        ps.setString(1, phone);
        ps.setInt(2, idUser);
        return ps.executeUpdate();
    }
}
