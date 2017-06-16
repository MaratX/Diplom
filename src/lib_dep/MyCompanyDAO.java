package lib_dep;

import objects.Address;
import objects.MyCompany;
import objects.User;

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
    private String sqlGetWorkerList = "SELECT idUser, role FROM mycompany WHERE idOrganization = ?";
    private String sqlUpdaterole = "UPDATE mycompany SET role = ? WHERE idUser = ? AND idOrganization = ?";
    private String sqldeleteworker = "DELETE FROM mycompany WHERE idUser = ? AND idOrganization = ?";
    private String sqladdworker = "INSERT INTO mycompany(idUser, idOrganization, role) VALUES (?, ?, ?)";

    public int addworker(int idUser, String role, int idOrg) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqladdworker);
        ps.setInt(1, idUser);
        ps.setInt(2, idOrg);
        ps.setString(3, role);
        return ps.executeUpdate();
    }

    public int deleteWorker(int idw, int idO) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqldeleteworker);
        ps.setInt(1, idw);
        ps.setInt(2, idO);
        return ps.executeUpdate();
    }

    public int updateRole(int idU, int idO, String role) throws SQLException{
        ps =jdbc.getCon().prepareStatement(sqlUpdaterole);
        ps.setString(1, role);
        ps.setInt(2, idU);
        ps.setInt(3, idO);
        return ps.executeUpdate();
    }

    public String getRole(int idUser, int idOrg) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlGetInCompanyRole);
        ps.setInt(1, idUser);
        ps.setInt(2, idOrg);
        rs = ps.executeQuery();
        if(rs.next()){
            return rs.getString(1);
        }
        return "";
    }

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

    public String getListWorker(String nameOrganization) throws SQLException{
        int idOrg = new OrganizationDAO().getIdOrganization(nameOrganization);
        ArrayList<User> UserList = new ArrayList<>();
        ArrayList<String> role = new ArrayList<>();
        String result = "";
        ps = jdbc.getCon().prepareStatement(sqlGetWorkerList);
        ps.setInt(1, idOrg);
        rs = ps.executeQuery();
        while (rs.next()){
            UserList.add(new AccountDAO().getUser(rs.getInt(1)));
            role.add(rs.getString(2));
        }
        for(int i = 0; i < UserList.size(); i++){
            Address a = new AddressDAO().getAddressById(UserList.get(i).getAddressUser());
            String adress = a.getCity() + " " + a.getStreet() + " " + a.getHome() + " " + a.getApartment();
            result  += UserList.get(i).getId() +"_"+ UserList.get(i).getLogin() + "_" + UserList.get(i).getName()
                    + " " + UserList.get(i).getLastName() + "_" + adress + "_" + role.get(i) + "_" + UserList.get(i).getPhone() + "|";
        }
        return result;
    }
}
