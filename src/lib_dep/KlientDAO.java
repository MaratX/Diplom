package lib_dep;

import objects.Address;
import objects.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Gustovs on 13.06.2017.
 */
public class KlientDAO  {
    private JDBC jdbc = new JDBC();
    private PreparedStatement ps;
    private ResultSet rs;

    private String sqlGetIdUser = "SELECT idUser FROM klient WHERE idOrganization = ?";
    private String sqlListOrg = "SELECT idOrganization FROM klient WHERE idUser = ?";
    private String sqldelete = "DELETE FROM klient WHERE idUser = ? AND idOrganization = ?";
    private String sqladd = "INSERT INTO klient(idUser, idOrganization) VALUES (?,?)";

    public int addKlient(int idUser, int idOrg) throws  SQLException{
        ps = jdbc.getCon().prepareStatement(sqladd);
        ps.setInt(1, idUser);
        ps.setInt(2, idOrg);
        return ps.executeUpdate();
    }

    public int deleteKlient(int User, int org) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqldelete);
        ps.setInt(1, User);
        ps.setInt(2, org);
        return ps.executeUpdate();
    }

    public String getList(String Organization) throws SQLException{
        int idOrg = new OrganizationDAO().getIdOrganization(Organization);
        String result = "";
        ArrayList<User> userList = new ArrayList<>();
        ps = jdbc.getCon().prepareStatement(sqlGetIdUser);
        ps.setInt(1, idOrg);
        rs = ps.executeQuery();
        while (rs.next()){
            userList.add(new AccountDAO().getUser(rs.getInt(1)));
        }
        for(User u : userList){
            Address a = new AddressDAO().getAddressById(u.getAddressUser());
            String adress = a.getCity() + " " + a.getStreet() + " " + a.getHome() + " " + a.getApartment();
            result += u.getId() + "_" + u.getLogin() + "_" + u.getName() + " " + u.getLastName() + "_" + adress + "_" + u.getPhone() + "|";
        }
        return result;
    }

    public ArrayList<Integer> getListIdOrganization(String login) throws SQLException{
        int id = new AccountDAO().getIdUser(login);
        ArrayList<Integer> list = new ArrayList<>();
        ps = jdbc.getCon().prepareStatement(sqlListOrg);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()){
            list.add(rs.getInt(1));
        }
        return list;
    }
}
