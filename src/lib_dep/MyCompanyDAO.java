package lib_dep;

import objects.MyCompany;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Gustovs on 31.03.2017.
 */
public class MyCompanyDAO {
    private JDBC jdbc = new JDBC();
    private PreparedStatement ps;
    private ResultSet rs;
    private String sqlCreateMyCompany = "INSERT INTO mycompany(idUser, idOrganization) VALUES (?,?)";
    private String sqlDeleteMyCompany = "DELETE FROM mycompany WHERE id = ?";
    private String sqlGetMyCompany = "SELECT idUser, idOrganization FROM mycompany WHERE id = ?";
    private String sqlGetListMyCompany = "SELECT id, idUser, idOrganization FROM  mycompany WHERE idUser = ?";
    private String sqlGetInCompanyRole = "SELECT role FROM mycompany WHERE idUser = ? AND idOrganization = ?";

    public int createMyCompany(int idUser, int idOrganization) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlCreateMyCompany, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, idUser);
        ps.setInt(2, idOrganization);
        ps.executeUpdate();
        rs = ps.getGeneratedKeys();
        if(rs.next()){
            return rs.getInt(1);
        }

        return -1;
    }

    public int deleteMyCompany(int idMyCompany) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlDeleteMyCompany);
        ps.setInt(1, idMyCompany);
        return ps.executeUpdate();
    }

    public MyCompany getMyCompany(int idMyCompany) throws SQLException{
        MyCompany m = null;
        ps = jdbc.getCon().prepareStatement(sqlGetMyCompany);
        ps.setInt(1, idMyCompany);
        rs = ps.executeQuery();
        if(rs.next()){
            m.setIdMyCompany(idMyCompany);
            m.setIdUser(rs.getInt(1));
            m.setIdOrganization(rs.getInt(2));
        }
        return m;
    }

    public ArrayList<MyCompany> getListMyCompany(int idUser) throws SQLException{
        ArrayList<MyCompany> list = new ArrayList<MyCompany>();
        ps = jdbc.getCon().prepareStatement(sqlGetListMyCompany);
        ps.setInt(1, idUser);
        rs = ps.executeQuery();
        while (rs.next()){
            list.add(new MyCompany(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
        }
        return list;
    }

    public String getInCompanyRole(String nameUser, int idOrg) throws SQLException{

        String sqlUserId = "SELECT idUser FROM user WHERE login = ?";

        ps = jdbc.getCon().prepareStatement(sqlUserId);
        ps.setString(1, nameUser);
        rs = ps.executeQuery();
        int idUser = -1;
        if(rs.next()){
            idUser = rs.getInt(1);
        }
        ps = null;
        rs = null;

        //---------------------------------------------------------

        ps = jdbc.getCon().prepareStatement(sqlGetInCompanyRole);
        ps.setInt(1, idUser);
        ps.setInt(2, idOrg);
        rs = ps.executeQuery();
        String role = "";
        if(rs.next()){
            role = rs.getString(1);
        }
        return role;
    }
}
